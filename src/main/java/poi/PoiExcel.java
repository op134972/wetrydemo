package poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Created by Wch on 2017/12/9.
 */
public class PoiExcel {

    private static final String inPath = "C:\\Users\\lele\\Desktop\\bend3.xlsx";
    private static final String outPath = "C:\\Users\\lele\\Desktop\\newbend3.xlsx";

    public static void main(String[] args) throws IOException {
        FileOutputStream fo = new FileOutputStream(outPath);
        FileInputStream fi = new FileInputStream(inPath);
        XSSFWorkbook inBook = new XSSFWorkbook(fi);
        try {
            XSSFSheet sheet = inBook.getSheetAt(0);
            int rowNums = sheet.getLastRowNum();
            for (int i = 0; i <= rowNums; i++) {
                if (i % 88 == 0) {
                    XSSFRow row = sheet.getRow(i);
                    XSSFCell c2 = row.getCell(1);
                    c2.setCellValue(9);
                }
            }
            inBook.write(fo);
        } finally {
            fi.close();
            fo.close();
        }
    }
}
