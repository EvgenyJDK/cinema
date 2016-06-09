package com.cinema.datasource;


import com.cinema.dao.storage.PropertyHolder;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataSource {


    private static ComboPooledDataSource poolConnections;
    private static DataSource dataSource;                                   // ST

//    public DataSource() {
//        initPoolConnections();
//    }
//
    public static synchronized DataSource getInstance() {                   // ST
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }
//
//    public Connection getConnection() {
//        Connection connection = null;
//        System.out.println(" connection try to init");
////        initPoolConnections();                                              //
//        try {
//            System.out.println("*****ЁЁЁЁЁЁЁЁЁ******");
//            System.out.println(connection);
//
//            connection = poolConnections.getConnection();                   // connection  getConnection  poolConnection Q
//
//            System.out.println("!!!!!!!!!");
////            Statement statement = connection.createStatement();
////            System.out.println(statement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    private static void initPoolConnections() {
//
//        System.out.println("init pool connections");
//        poolConnections = new ComboPooledDataSource();
//        PropertyHolder propertyHolder = PropertyHolder.getInstance();
//        try {
//            poolConnections.setDriverClass(propertyHolder.getDbDriver());           //loads the jdbc driver
//
//            poolConnections.setJdbcUrl(propertyHolder.getJdbcUrl());
//            poolConnections.setUser(propertyHolder.getDbUserLogin());
//            poolConnections.setPassword(propertyHolder.getDbUserPassword());
//
//            poolConnections.setMinPoolSize(1);
//            poolConnections.setAcquireIncrement(1);
//            poolConnections.setMaxPoolSize(5);
//            System.out.println(poolConnections);
//            System.out.println("~~~~~~~~~~~~~");
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//    }


    // Прямой вариант

    public Connection getConnection () throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");                               //loads the jdbc driver
//        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/sales_db");
//        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/create");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/cinema");
        cpds.setUser("root");
        cpds.setPassword("root");

        cpds.setMinPoolSize(3);
        cpds.setAcquireIncrement(1);
        cpds.setMaxPoolSize(100);
        Connection conn = cpds.getConnection();
    Statement statement = conn.createStatement();
//    ResultSet resultSet = statement.executeQuery("Select * from customers");
//        ResultSet resultSet = statement.executeQuery("Select * from cinema.user");
        ResultSet resultSet = statement.executeQuery("Select * from cinema.movie");
        System.out.println("DataSource Select from cinema.user");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString(2);
            System.out.println(id);
            System.out.println(name);
        }
    return  conn;
}


}










