package ru.mytnik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mytnik.db.MySQLConnector;
import ru.mytnik.domain.Dolzhnost;

public class DolzhnostDAO implements DAOInterface<Dolzhnost> {

    private Connection con;

    public DolzhnostDAO() {
        MySQLConnector connector = new MySQLConnector();
        Properties dbSettings = new Properties();
        dbSettings.setProperty("db.host", "46.101.181.249");
        dbSettings.setProperty("db.name", "student-gibdd");
        dbSettings.setProperty("db.user", "std");
        dbSettings.setProperty("db.password", "std123");
        connector.setDbSettings(dbSettings);
        con = connector.getDBConnect();
    }

    @Override
    public void persist(Dolzhnost value) {
        String sql = "INSERT INTO `student-gibdd`.`dolzhnost`"
                + "(`name`,"
                + "`oklad`,"
                + "`obazannost`,"
                + "`trebovania`)"
                + "VALUES"
                + "(?,"
                + "?,"
                + "?,"
                + "?);";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getName());
            st.setInt(2, value.getOklad());
            st.setString(3, value.getObiazanost());
            st.setString(4, value.getTrebovanija());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DolzhnostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Dolzhnost value) {
        String sql = "DELETE FROM `student-gibdd`.`dolzhnost`" +
"WHERE id = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DolzhnostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Dolzhnost value) {
        String sql = "";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DolzhnostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dolzhnost findById(Integer id) {
        Dolzhnost d = new Dolzhnost();
        String sql = "";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setOklad(rs.getInt("oklad"));
                d.setObiazanost(rs.getString("obazannost"));
                d.setTrebovanija(rs.getString("trebovania"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DolzhnostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public List<Dolzhnost> findAll() {
        List<Dolzhnost> dolzhnosti = new ArrayList<>();
        String sql = "SELECT * FROM dolzhnost";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Dolzhnost d = new Dolzhnost();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setOklad(rs.getInt("oklad"));
                d.setObiazanost(rs.getString("obazannost"));
                d.setTrebovanija(rs.getString("trebovania"));
                dolzhnosti.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DolzhnostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dolzhnosti;
    }

}
