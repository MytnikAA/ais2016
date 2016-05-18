package ru.mytnik.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

public class MySQLConnectorTest {
    
    public MySQLConnectorTest() {
    }

    @Test
    public void testSetDbSettings() {
        System.out.println("setDbSettings");
        Properties dbSettings = new Properties();
        dbSettings.setProperty("test", "test");
        MySQLConnector instance = new MySQLConnector();
        instance.setDbSettings(dbSettings);
        Properties actual = instance.getDbSettings();
        assertEquals(dbSettings, actual);
    }

    /**
     * Test of getDBConnect method, of class MySQLConnector.
     */
    @Test
    public void testGetDBConnect() throws SQLException {
        System.out.println("getDBConnect");
        MySQLConnector instance = new MySQLConnector();
        Properties dbSettings = new Properties();
        dbSettings.setProperty("db.host", "stddb.mytnik.ru");
        dbSettings.setProperty("db.name", "student-gibdd");
        dbSettings.setProperty("db.user", "std");
        dbSettings.setProperty("db.password", "std123");
        instance.setDbSettings(dbSettings);
        Connection con = instance.getDBConnect();
        assertNotNull(con);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select 2+2 as sum;");
        if (rs.next()) {
            String sum = rs.getString("sum");
            assertEquals(sum, "4");
        } else {
            fail();
        }
    }
    
}
