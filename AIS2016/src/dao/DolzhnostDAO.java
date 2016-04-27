package dao;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import ru.tspu.fmf.mytnik.db.MySQLConnector;
import ru.tspu.fmf.mytnik.domain.Dolzhnost;

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
    }

    @Override
    public void delete(Dolzhnost value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Dolzhnost value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dolzhnost findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dolzhnost> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
