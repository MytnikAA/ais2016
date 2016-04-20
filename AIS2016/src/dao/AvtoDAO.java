package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.tspu.fmf.mytnik.db.MySQLConnector;
import ru.tspu.fmf.mytnik.domain.Avto;

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
                + "`dateTO`,"
                + "`avtocol`)"
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
                + "?,"
                + "?);";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, value.getIdMarka());
            statement.setString(2, value.getNomer());
        } catch (SQLException ex) {
            Logger.getLogger(AvtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Avto value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Avto value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Avto findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Avto> findById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
