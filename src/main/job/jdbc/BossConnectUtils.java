package jdbc;

import java.sql.*;

public class BossConnectUtils {


    private static final Connection conn = getConn();

    public static String getAreaCode(String cityName, String areaName) {
        Statement st = null;
        try {
            if (conn == null) {
                return "";
            }
            st = conn.createStatement();
            String sql = "select ad_code from job_area where district = '" + areaName + "' and city_name = '" + cityName + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String res = rs.getString(1);
                return res;
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getCityCode(String cityName) {
        Statement st = null;
        try {
            if (conn == null) {
                return "";
            }
            st = conn.createStatement();
            String sql = "select city_code from job_area where  city_name = '" + cityName + "' limit 1";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String res = rs.getString(1);
                return res;
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static String getCityCodeFromAmapTableByCityName(String cityName) {
        String sql = "select city_code from amap_district where name = ? limit 1";
        PreparedStatement psmt = null;
        try {
            if (conn == null) {
                return "";
            }
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cityName);
            ResultSet resultSet = psmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getAreaCodeFromAmapTableByCityCodeAndAreaName(String areaName, String cityCode) {
        String sql = "select adcode from amap_district where name = ? and city_code = ? limit 1";
        PreparedStatement psmt = null;
        try {
            if (conn == null) {
                return "";
            }
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, areaName);
            psmt.setString(2, cityCode);
            ResultSet resultSet = psmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    private static Connection getConn() {
        String URL = "jdbc:mysql://192.168.1.31:3306/boss?useUnicode=true&amp;characterEncoding=utf-8";
        String USER = "boss";
        String PASSWORD = "boss";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
