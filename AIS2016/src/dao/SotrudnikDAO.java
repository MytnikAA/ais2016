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
import ru.tspu.fmf.mytnik.domain.Sotrudnik;


public class SotrudnikDAO implements DAOInterface<Sotrudnik>{
    
    private Connection con;
    
    public SotrudnikDAO(){
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
    public void persist(Sotrudnik value) {
        String sql = "INSERT INTO `student-gibdd`.`sotrudnik`"
                + "(`id_zvanie`,"
                + "`id_dolzhnost`,"
                + "`id_person`)"
                + "VALUES"
                + "(?,"
                + "?,"
                + "?,)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getIdZvanie());
            st.setInt(2, value.getIdDolzhnost());
            st.setInt(3, value.getIdPerson());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SotrudnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Sotrudnik value) {
        String sql = "DELETE FROM `student-gibdd`.`sotrudnik`" + "WHERE id=?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SotrudnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Sotrudnik value) {
        String sql = "UPDATE `student-gibdd`.`sotrudnik`"
                + "SET"
                + "`id_zvanie` = ?,"
                + "`id_dolzhnost` = ?,"
                + "`id_person` = ?"
                + "WHERE `id` = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getIdZvanie());
            st.setInt(2, value.getIdDolzhnost());
            st.setInt(3, value.getIdPerson());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SotrudnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Sotrudnik findById(Integer id) {
        Sotrudnik sotrudnik = new Sotrudnik();
        String sql = "SELECT * FROM `student-gibdd`.`sotrudnik`" + "WHERE id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sotrudnik.setId(rs.getInt("id"));
                sotrudnik.setIdZvanie(rs.getInt("id_zvanie"));
                sotrudnik.setIdDolzhnost(rs.getInt("id_dolzhnost"));
                sotrudnik.setIdPerson(rs.getInt("id_person"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SotrudnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sotrudnik;
    }

    @Override
    public List<Sotrudnik> findAll() {
        List<Sotrudnik> result = new ArrayList<>();
        String sql = "SELECT * FROM `student-gibdd`.`sotrudnik`";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Sotrudnik sotrudnik = new Sotrudnik();
            sotrudnik.setId(rs.getInt("id"));
            sotrudnik.setIdZvanie(rs.getInt("id_zvanie"));
            sotrudnik.setIdDolzhnost(rs.getInt("id_dolzhnost"));
            sotrudnik.setIdPerson(rs.getInt("id_person")); 
            result.add(sotrudnik);
        } catch (SQLException ex) {
            Logger.getLogger(SotrudnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
