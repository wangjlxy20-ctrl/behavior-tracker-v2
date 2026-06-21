package com.tracker.jdbc_util;

import java.sql.*;

public class jdbc_util {
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/behavior_tracker";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        return connection;
    }

    public static void close_all(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
        if(resultSet != null){
            resultSet.close();
        } else if (preparedStatement != null) {
            preparedStatement.close();
        } else if (connection != null) {
            connection.close();
        }
    }
}
