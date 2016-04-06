package ru.tspu.fmf.mytnik.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public synchronized Connection getDBConnect(String host) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            host = dbSettings.getProperty("db.host");
            String port = dbSettings.getProperty("db.port", "3306");
            String name = dbSettings.getProperty("db.name");
            String user = dbSettings.getProperty("db.user");
            String password = dbSettings.getProperty("db.password");
            connection = DriverManager
                    .getConnection("jdbc:mysql://" + host + ":" + port + "/" + name, user, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return connection;
    }

}
