package com.lm.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Title: JDBCUtil
 * @Author:LiMan
 * @Date:2018/3/7 11:42
 * @Description:
 */
public class JDBCUtil {
    public static Connection getConnection() throws Exception {
        /*String url = "jdbc:mysql:///bootdemo";
        String user = "root";
        String psd = "123456";
        String driverClass = "com.mysql.jdbc.Driver";*/
        InputStream input = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(input);
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String psd = properties.getProperty("psd");
        String driverClass = properties.getProperty("driver.class");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,psd);
        return connection;
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if(resultSet != null){
            resultSet.close();
        }
        if(statement != null){
            statement.close();
        }
        if(connection != null){
            connection.close();
        }
    }



}
