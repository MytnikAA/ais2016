package ru.mytnik.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mytnik.db.MySQLConnector;
import ru.mytnik.domain.Marka;

public class MarkaDAO implements DAOInterface<Marka> {

    private Connection con;

    public MarkaDAO() {
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
    public void persist(Marka value) {
        String sql = "INSERT INTO `student-gibdd`.`marka`"
                + "(`name`,"
                + "`firma`,"
                + "`markacol`,"
                + "`haracteristiki`,"
                + "`kategoria`,"
                + "`opisanie`,"
                + "`startVupusk`,"
                + "`stopVupusk`)"
                + "VALUES"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getName());
            st.setString(2, value.getFirma());
            st.setString(3, value.getMarkaCol());
            st.setString(4, value.getHaracteristiki());
            st.setString(5, value.getKategoria());
            st.setString(6, value.getOpisanie());
            java.sql.Date d = new Date(value.getStartVupusk().getTime());
            st.setDate(7, d);
            d = new java.sql.Date(value.getStopVupusk().getTime());
            st.setDate(8, d);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MarkaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Marka value) {
        String sql = "DELETE FROM `student-gibdd`.`marka`"
                + "WHERE id = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MarkaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Marka value) {
        String sql = "UPDATE `student-gibdd`.`marka`"
                + "SET"
                + "`name` = ?,"
                + "`firma` = ?,"
                + "`markacol` = ?,"
                + "`haracteristiki` = ?,"
                + "`kategoria` = ?,"
                + "`opisanie` = ?,"
                + "`startVupusk` = ?,"
                + "`stopVupusk` = ?"
                + "WHERE `id` = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getName());
            st.setString(2, value.getFirma());
            st.setString(3, value.getMarkaCol());
            st.setString(4, value.getHaracteristiki());
            st.setString(5, value.getKategoria());
            st.setString(6, value.getOpisanie());
            java.sql.Date d = new Date(value.getStartVupusk().getTime());
            st.setDate(7, d);
            d = new java.sql.Date(value.getStopVupusk().getTime());
            st.setDate(8, d);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarkaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Marka findById(Integer id) {
        Marka marka = new Marka();
        String sql = "SELECT * FROM `student-gibdd`.`marka`" + "WHERE id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                marka.setId(rs.getInt("id"));
                marka.setName(rs.getString("name"));
                marka.setFirma(rs.getString("firma"));
                marka.setMarkaCol(rs.getString("markacol"));
                marka.setHaracteristiki(rs.getString("haracteristiki"));
                marka.setKategoria(rs.getString("kategoria"));
                marka.setOpisanie(rs.getString("opisanie"));
                marka.setStartVupusk(rs.getDate("startvupusk"));
                marka.setStopVupusk(rs.getDate("stopvupusk"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marka;
    }

    @Override
    public List<Marka> findAll() {
        List<Marka> result = new ArrayList<>();
        String sql = "SELECT * FROM Marka";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                 Marka marka = new Marka();
                 marka.setId(rs.getInt("id"));
                marka.setName(rs.getString("name"));
                marka.setFirma(rs.getString("firma"));
                marka.setMarkaCol(rs.getString("markacol"));
                marka.setHaracteristiki(rs.getString("haracteristiki"));
                marka.setKategoria(rs.getString("kategoria"));
                marka.setOpisanie(rs.getString("opisanie"));
                marka.setStartVupusk(rs.getDate("startvupusk"));
                marka.setStopVupusk(rs.getDate("stopvupusk"));
                result.add(marka);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
