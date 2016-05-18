package ru.mytnik.dao;

import java.sql.Connection;
import java.sql.Date;
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
import ru.mytnik.domain.GTA;

public class GTADAO implements DAOInterface<GTA> {

    private Connection con;

    public GTADAO() {
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
    public void persist(GTA value) {
        String sql = "INSERT INTO `student-gibdd`.`gta`"
                + "(`id_avto`,"
                + "`ugon`,"
                + "`obraschenia`,"
                + "`obstoiatelstva`,"
                + "`otmetkaNahodki`,"
                + "`dateNahodki`)"
                + "VALUES"
                + "(?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getIdAvto());
            java.sql.Date d = new Date(value.getUgon().getTime());
            st.setDate(2, d);
            d = new Date(value.getObraschenia().getTime());
            st.setDate(3, d);
            st.setString(4, value.getObstoiatelstva());
            st.setBoolean(5, value.getOtmetkaNahodki());
            d = new java.sql.Date(value.getDateNahodki().getTime());
            st.setDate(6, d);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GTADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(GTA value) {
        String sql = "DELETE FROM `student-gibdd`.`gta`"
                + "WHERE = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GTADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GTA value) {
        String sql = "UPDATE `student-gibdd`.`gta`"
                + "SET"
                + "`id_avto` = ?"
                + "`ugon` = ?"
                + "`obraschenia` = ?"
                + "`obstoiatelstva` = ?"
                + "`otmetkaNahodki` = ?"
                + "`dateNahodki` = ?"
                + "WHERE `id` = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getIdAvto());
            java.sql.Date d = new Date(value.getUgon().getTime());
            st.setDate(2, d);
            d = new Date(value.getObraschenia().getTime());
            st.setDate(3, d);
            st.setString(4, value.getObstoiatelstva());
            st.setBoolean(5, value.getOtmetkaNahodki());
            d = new java.sql.Date(value.getDateNahodki().getTime());
            st.setDate(6, d);
            st.setInt(7, value.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GTADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public GTA findById(Integer id) {
        GTA gta = new GTA();
        String sql = "SELECT * FROM GTA WHERE id= ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                gta.setId(rs.getInt("id"));
                gta.setUgon(rs.getDate("ugon"));
                gta.setObraschenia(rs.getDate("obraschenia"));
                gta.setObstoiatelstva(rs.getString("obstoiatelstva"));
                gta.setOtmetkaNahodki(rs.getBoolean("otmetkaNahodki"));
                gta.setDateNahodki(rs.getDate("dateNahodki"));
                gta.setIdAvto(rs.getInt("id_avto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GTADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gta;
    }

    @Override
    public List<GTA> findAll() {
        List<GTA> list = new ArrayList<>();
        String sql = "SELECT * FROM GTA";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                GTA gta = new GTA();
                gta.setId(rs.getInt("id"));
                gta.setUgon(rs.getDate("ugon"));
                gta.setObraschenia(rs.getDate("obraschenia"));
                gta.setObstoiatelstva(rs.getString("obstoiatelstva"));
                gta.setOtmetkaNahodki(rs.getBoolean("otmetkaNahodki"));
                gta.setDateNahodki(rs.getDate("dateNahodki"));
                gta.setIdAvto(rs.getInt("id_avto"));
                list.add(gta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GTADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
