package ru.mytnik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mytnik.db.MySQLConnector;
import ru.mytnik.domain.Avto;

public class AvtoDAO implements DAOInterface<Avto> {

    private Connection con;

    public AvtoDAO() {
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
    public void persist(Avto value) {
        String sql = "INSERT INTO `student-gibdd`.`avto`"
                + "(`id_marka`,"
                + "`id_vladelets`,"
                + "`nomer`,"
                + "`nomerKyzova`,"
                + "`nomerDvigla`,"
                + "`nomerTP`,"
                + "`vypusk`,"
                + "`reg`,"
                + "`color`,"
                + "`TO`,"
                + "`dateTO`)"
                + "VALUES"
                + "(?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, value.getIdMarka());
            statement.setInt(2, value.getIdVladelets());
            statement.setString(3, value.getNomer());
            statement.setString(4, value.getNomerKyzova());
            statement.setString(5, value.getNomerDvigla());
            statement.setString(6, value.getNomerTP());
            java.sql.Date date = new java.sql.Date(value.getVypusk().getTime());
            statement.setDate(7, date);
            date = new java.sql.Date(value.getReg().getTime());
            statement.setDate(8, date);
            statement.setString(9, value.getColor());
            statement.setString(10, value.getTO());
            date = new java.sql.Date(value.getDateTO().getTime());
            statement.setDate(10, date);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AvtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Avto value) {
        String sql = "DELETE FROM `student-gibdd`.`avto`"
                + "WHERE id=?;";
        PreparedStatement st;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AvtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Avto value) {
        String sql = "UPDATE `student-gibdd`.`avto`"
                + "SET"
                + "`id_marka` = ?,"
                + "`id_vladelets` = ?,"
                + "`nomer` = ?,"
                + "`nomerKyzova` = ?,"
                + "`nomerDvigla` = ?,"
                + "`nomerTP` = ?,"
                + "`vypusk` = ?,"
                + "`reg` = ?,"
                + "`color` = ?,"
                + "`TO` = ?,"
                + "`dateTO` = ?,"
                + "WHERE `id` = ?";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, value.getIdMarka());
            statement.setInt(2, value.getIdVladelets());
            statement.setString(3, value.getNomer());
            statement.setString(4, value.getNomerKyzova());
            statement.setString(5, value.getNomerDvigla());
            statement.setString(6, value.getNomerTP());
            java.sql.Date date = new java.sql.Date(value.getVypusk().getTime());
            statement.setDate(7, date);
            date = new java.sql.Date(value.getReg().getTime());
            statement.setDate(8, date);
            statement.setString(9, value.getColor());
            statement.setString(10, value.getTO());
            date = new java.sql.Date(value.getDateTO().getTime());
            statement.setDate(10, date);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Avto findById(Integer id) {
        Avto avto = new Avto();
        String sql = "SELECT * FROM `student-gibdd`.`avto`"
                + "WHERE id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                avto.setId(rs.getInt("id"));
                avto.setIdMarka(rs.getInt("id_marka"));
                avto.setIdVladelets(rs.getInt("id_vladelets"));
                avto.setNomer(rs.getString("nomer"));
                avto.setNomerKyzova(rs.getString("nomerKyzova"));
                avto.setNomerDvigla(rs.getString("nomerDvigla"));
                avto.setNomerTP(rs.getString("nomerTP"));
                avto.setVypusk(rs.getDate("vypusk"));
                avto.setReg(rs.getDate("reg"));
                avto.setColor(rs.getString("color"));
                avto.setTO(rs.getString("TO"));
                avto.setDateTO(rs.getDate("dateTO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avto;
    }

    @Override
    public List<Avto> findAll() {
        List<Avto> result = new ArrayList<>();
        String sql = "SELECT * FROM `student-gibdd`.`avto`";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Avto avto = new Avto();
                avto.setId(rs.getInt("id"));
                avto.setIdMarka(rs.getInt("id_marka"));
                avto.setIdVladelets(rs.getInt("id_vladelets"));
                avto.setNomer(rs.getString("nomer"));
                avto.setNomerKyzova(rs.getString("nomerKyzova"));
                avto.setNomerDvigla(rs.getString("nomerDvigla"));
                avto.setNomerTP(rs.getString("nomerTP"));
                avto.setVypusk(rs.getDate("vypusk"));
                avto.setReg(rs.getDate("reg"));
                avto.setColor(rs.getString("color"));
                avto.setTO(rs.getString("TO"));
                avto.setDateTO(rs.getDate("dateTO"));
                result.add(avto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
