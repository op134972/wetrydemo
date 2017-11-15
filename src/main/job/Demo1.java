import jdbc.BossConnectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class Demo1 {

    private static final ConcurrentHashMap<String, String> CITY_CODE_CACHE = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> AREA_CODE_CACHE = new ConcurrentHashMap<>();

    public static void exportDistrictInsertSql(String cityName, String filePath) throws IOException {
        String fileName = filePath + "/" + cityName;
        File fileIn = new File(fileName);

        String sqlPre = "insert into job_area(city_code,city_name,district,ad_code,business_name,add_time,update_time)";


        /**
         * 1、文件名决定：城市
         * 2、空行后的第一行决定：区域
         * 3、之后的决定：商圈
         *
         *
         * 输出的是   城市：区域：商圈
         *
         *
         * id
         city_code
         city_name
         district
         ad_code
         business_name
         add_time
         update_time
         valid_job_count

         直接为每一个商圈生成一条sql语句



         */
        FileReader fr = new FileReader(fileIn);
        BufferedReader br = new BufferedReader(fr);

        StringBuffer sql = new StringBuffer();


        boolean firstLine = true;
        boolean secondLine = false;
        String areaName = null;
        String district;
        String line;
        while ((line = br.readLine()) != null) {//每一行每一行的读

            if (StringUtils.isEmpty(line) && !secondLine) {//是空行，说明换了商圈。 若干为空行并且为第二行，说明该行政区域无商圈，同样需要插入
                firstLine = true;
                continue;
            }
            if (firstLine && StringUtils.isNotEmpty(line)) {//非空行的第一行，确定 区域名
                areaName = StringUtils.trim(line);
                firstLine = false;
                secondLine = true;
                continue;
            }
            secondLine = false;
            //非空行的非第一行   确定商圈名
            district = StringUtils.trim(line);

            /**
             * 生成sql语句，需要查询 cityCode ad_code信息
             *
             * 1、先查缓存
             * 2、没有，查job_area表
             * 3、没有，查amap_district
             * 4、加入缓存
             */
            String cityCode = CITY_CODE_CACHE.get(cityName);
            if (StringUtils.isEmpty(cityCode)) {
                cityCode = BossConnectUtils.getCityCode(cityName);
                if (StringUtils.isEmpty(cityCode)) {//3、查询amap_district
                    cityCode = BossConnectUtils.getCityCodeFromAmapTableByCityName(cityName);
                }
                if (StringUtils.isEmpty(cityCode)) {//三次查询都为空的处理
                    cityCode = "-1";
                } else {
                    CITY_CODE_CACHE.put(cityName, cityCode);
                }
            }
            String areaCode = AREA_CODE_CACHE.get(cityName + areaName);
            if (StringUtils.isEmpty(areaCode)) {
                areaCode = BossConnectUtils.getAreaCode(cityName, areaName);
                if (StringUtils.isEmpty(areaCode)) {
                    areaCode = BossConnectUtils.getAreaCodeFromAmapTableByCityCodeAndAreaName(areaName,cityCode);
                }
                if (StringUtils.isEmpty(areaCode)) {
                    areaCode = "-1";
                }else{
                    AREA_CODE_CACHE.put(cityName + areaName, areaCode);
                }
            }

            sql.append(sqlPre + "values( '" + cityCode + "', '" + cityName + "' ,'" + areaName + "', '" + areaCode + "','" + district + "',now(),now());");

            sql.append("\n");
        }

        // sql生成完毕，写出
        String outFileName = filePath + "/out/" + cityName + ".sql";
        File fileOut = new File(outFileName);
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }
        FileWriter fw = new FileWriter(fileOut);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(sql.toString());
        bw.flush();
        System.out.println(sql.toString());
    }


    public static void main(String[] args) {
//        String sqlPre = "insert into job_area(city_code,city_name,district,ad_code,business_name,add_time,update_time)";
//        String cityCode = "123";
//        String cityName = "北京";
//        String areaCode = "456";
//        String areaName = "朝阳区";
//        String district = "五道口";
//        StringBuffer sql = new StringBuffer();
//        sql.append(sqlPre+ "values( "+cityCode +", '"+cityName+ "' ,'"+areaName+"', "+areaCode + ","+district+",now(),now())");
//
//
//        System.out.println(sql.toString());


        try {
            String filePath = "/home/wch/桌面/file/DistrictInsert";
            File districtFiles = new File(filePath);
            File[] files = districtFiles.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    String cityName = file.getName();
                    System.out.printf("正在生成%ssql......\n ", cityName);
                    exportDistrictInsertSql(cityName, filePath);
                } else {

                }
            }


            System.out.println(AREA_CODE_CACHE.entrySet().toString());
            System.out.println(CITY_CODE_CACHE.entrySet().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
