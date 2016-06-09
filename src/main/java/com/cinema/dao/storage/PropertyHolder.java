package com.cinema.dao.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by User on 07.04.2016.
 */


public final class PropertyHolder {

    public static PropertyHolder propertyHolder;
    private final static String propertiesPath = "src\\main\\resources\\application.properties";
    private static Boolean isInMemoryDB;

    private static String dbDriver;
    private static String jdbcUrl;
    private static String dbUserLogin;
    private static String dbUserPassword;

    public PropertyHolder() {
        loadProperties();
    }

    public static synchronized PropertyHolder getInstance() {
        if (propertyHolder == null) {
            propertyHolder = new PropertyHolder();
        }
        return propertyHolder;
    }

//    public static PropertyHolder getInstance() {
//        if (propertyHolder == null) {
//            synchronized (PropertyHolder.class) {
//                if (propertyHolder == null) {
//                    propertyHolder = new PropertyHolder();
//                }
//            }
//        }
//        return propertyHolder;
//    }

    private void loadProperties() {
        InputStream intStream = null;
        Properties prop = new Properties();
        try {
            intStream = new FileInputStream(propertiesPath);
            prop.load(intStream);
            this.isInMemoryDB = Boolean.valueOf(prop.getProperty("isInMemoryDB"));
            this.dbDriver = prop.getProperty("dbDriver");
            this.jdbcUrl = prop.getProperty("jdbcUrl");
            this.dbUserLogin = prop.getProperty("dbUserLogin");
            this.dbUserPassword = prop.getProperty("dbUserPassword");
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (intStream != null) {
                try {
                    intStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Boolean isInMemoryDB() { return isInMemoryDB; }
    public String getDbDriver() { return dbDriver; }
    public String getJdbcUrl() { return jdbcUrl; }
    public String getDbUserLogin() { return dbUserLogin; }
    public String getDbUserPassword() { return dbUserPassword; }


}

