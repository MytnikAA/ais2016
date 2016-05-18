package ru.mytnik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mytnik.domain.Zvanie;

public class ZvanieDAO implements DAOInterface<Zvanie> {

    private Connection con;

    public ZvanieDAO(Connection c) {
        con = c;
    }

    @Override
    public void persist(Zvanie value) {
        String sql = "INSERT INTO `student-gibdd`.`zvanie`"
                + "(`name`,"
                + "`nadbavka`,"
                + "`obiazanost`,"
                + "`trebovanija`)"
                + "VALUES"
                + "(?,"
                + "?,"
                + "?,"
                + "?);";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getName());
            st.setInt(2, value.getNadbavka());
            st.setString(3, value.getObiazanost());
            st.setString(4, value.getTrebovanija());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ZvanieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Zvanie value) {
        String sql = "DELETE FROM `student-gibdd`.`zvanie`" + "WHERE id = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ZvanieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Zvanie value) {
        String sql = "UPDATE `student-gibdd`.`zvanie`"
                + "SET"
                + "`name` = ?,"
                + "`nadbavka` = ?,"
                + "`obiazanost` = ?,"
                + "`trebovanija` = ?"
                + "WHERE `id` = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getName());
            st.setInt(2, value.getNadbavka());
            st.setString(3, value.getObiazanost());
            st.setString(4, value.getTrebovanija());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ZvanieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Zvanie findById(Integer id) {
        Zvanie zvanie = new Zvanie();
        String sql = "SELECT * FROM `student-gibdd`.`zvanie`" + "WHERE id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                zvanie.setId(rs.getInt("id"));
                zvanie.setName(rs.getString("name"));
                zvanie.setNadbavka(rs.getInt("nadbavka"));
                zvanie.setObiazanost(rs.getString("obiazanost"));
                zvanie.setTrebovanija(rs.getString("trebovanija"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZvanieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zvanie;
    }

    @Override
    public List<Zvanie> findAll() {
        List<Zvanie> result = new ArrayList<>();
        String sql = "SELECT * FROM `student-gibdd`.`zvanie`";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Zvanie zvanie = new Zvanie();
                zvanie.setId(rs.getInt("id"));
                zvanie.setName(rs.getString("name"));
                zvanie.setNadbavka(rs.getInt("nadbavka"));
                zvanie.setObiazanost(rs.getString("obiazanost"));
                zvanie.setTrebovanija(rs.getString("trebovanija"));
                result.add(zvanie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZvanieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
