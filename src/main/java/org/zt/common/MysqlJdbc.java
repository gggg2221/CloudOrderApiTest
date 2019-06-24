package org.zt.common;

import java.sql.*;


public class MysqlJdbc {

    private static final String name = "com.mysql.jdbc.Driver";
    private static final String user = "test";
    private static final String password = "Jht123456";

    //请求数据列名
    private static String resdata = null;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;


    //打开数据库(测试数据)
    public static void testldb(String database) throws SQLException {
        String db = database;
        String url = "jdbc:mysql://10.10.203.10:3306/" + db + "";
        // 注册 MysqlJdbc 驱动
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //关闭连接
    public static void connclose() {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //取数据
    public static String Postdata(String dbase, String table, String classname, String sign) throws SQLException {
        testldb(dbase);
        String sql;
        stmt = conn.createStatement();

        if (sign != "") {
            sql = "SELECT sign from " + table + " where classname='" + classname + "'";
            rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while (rs.next()) {
                resdata = rs.getString("sign");
            }
        } else {
            sql = "SELECT data from " + table + " where classname='" + classname + "'";
            rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while (rs.next()) {
                resdata = rs.getString("data");
            }
        }

        return resdata;
    }

    //查询对应数据
    public static String seledata(String dbase, String sql, String col) throws SQLException {
        testldb(dbase);
        String sqls;
        sqls = sql;
        rs = stmt.executeQuery(sqls);
        // 展开结果集数据库
        while (rs.next()) {
            resdata = rs.getString(col);
        }
        if (!resdata.equals("")) {
            return resdata;
        } else {
            return "nothing";
        }
    }
}




