package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.tspu.fmf.mytnik.db.MySQLConnector;
import ru.tspu.fmf.mytnik.domain.Voditel;

public class VoditelDAO implements DAOInterface<Voditel> {

    private Connection con;

    public VoditelDAO() {
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
    public void persist(Voditel value) {
        String sql = "INSERT INTO `student-gibdd`.`voditel`"
                + "(`id_person`,"
                + "`nomerVU`,"
                + "`vydacha`,"
                + "`kategiria`,"
                + "`opisanie`)"
                + "VALUES"
                + "(?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getIdPerson());
            st.setString(2, value.getNomerVU());
            java.sql.Date d = new java.sql.Date(value.getVydacha().getTime());
            st.setDate(3, d);
            st.setString(4, value.getKategiria());
            st.setString(6, value.getOpisanie());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VoditelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Voditel value) {
        String sql = "DELETE FROM `student-gibdd`.`voditel`" + "WHERE id = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VoditelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Voditel value) {
        String sql = "UPDATE `student-gibdd`.`voditel`"
                + "SET"
                + "`id_person` = ?,"
                + "`nomerVU` = ?,"
                + "`vydacha` = ?,"
                + "`kategiria` = ?,"
                + "`opisanie` = ?"
                + "WHERE `id` = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getIdPerson());
            st.setString(2, value.getNomerVU());
            java.sql.Date d = new java.sql.Date(value.getVydacha().getTime());
            st.setDate(3, d);
            st.setString(4, value.getKategiria());
            st.setString(6, value.getOpisanie());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoditelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Voditel findById(Integer id) {
        Voditel voditel = new Voditel();
        String sql = "SELECT * FROM `student-gibdd`.`voditel`" + "WHERE id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                voditel.setId(rs.getInt("id"));
                voditel.setIdPerson(rs.getInt("id_person"));
                voditel.setNomerVU(rs.getString("nomerVU"));
                voditel.setVydacha(rs.getDate("vydacha"));
                voditel.setKategiria(rs.getString("kategoria"));
                voditel.setOpisanie(rs.getString("opisanie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoditelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voditel;
    }

    @Override
    public List<Voditel> findAll() {
        List<Voditel> result = new ArrayList<>();
        String sql = "SELECT * FROM `student-gibdd`.`voditel`";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Voditel voditel = new Voditel();
                voditel.setId(rs.getInt("id"));
                voditel.setIdPerson(rs.getInt("id_person"));
                voditel.setNomerVU(rs.getString("nomerVU"));
                voditel.setVydacha(rs.getDate("vydacha"));
                voditel.setKategiria(rs.getString("kategoria"));
                voditel.setOpisanie(rs.getString("opisanie"));
                result.add(voditel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoditelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
