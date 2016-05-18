package ru.mytnik.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Подключатель к СУБД MySQL
 * @author maa
 */
public class MySQLConnector {

    private Properties dbSettings;
    protected Connection connection;

    public void setDbSettings(Properties dbSettings) {
        this.dbSettings = dbSettings;
    }

    public Properties getDbSettings() {
        return dbSettings;
    }
    
    public synchronized Connection getDBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        try {
            String host = dbSettings.getProperty("db.host");
            String port = dbSettings.getProperty("db.port", "3306");
            String name = dbSettings.getProperty("db.name");
            String user = dbSettings.getProperty("db.user");
            String password = dbSettings.getProperty("db.password");
            connection = DriverManager
                    .getConnection("jdbc:mysql://" + host + ":" + 
                            port + "/" + name, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return connection;
    }
}
