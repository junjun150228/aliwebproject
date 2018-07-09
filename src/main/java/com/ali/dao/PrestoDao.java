package com.ali.dao;

import java.sql.*;

/**
 * prestodao链接类
 */
public class PrestoDao {

    public static final String url = "jdbc:presto://master:8080/hive/ali";
    public static final String name = "com.facebook.presto.jdbc.PrestoDriver";
    public static final String user = "root";
    public static final String password = null;

    public Connection conn = null;
    public PreparedStatement pst = null;

    public ResultSet exec(String sql) {
        ResultSet rs = null;
        try {
            Class.forName(name);//指定连接类型
            conn =  DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrestoDao a = new PrestoDao();
        try {
            ResultSet rs = a.exec("show tables");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            args.clone();
        }

    }

}
