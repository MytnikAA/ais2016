package ru.mytnik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mytnik.domain.Person;

public class PersonDAO implements DAOInterface<Person> {

    private Connection con;

    public PersonDAO(Connection c) {
        con = c;
    }

    @Override
    public void persist(Person value) {
        String sql = "INSERT INTO `student-gibdd`.`person`"
                + "(`fio`,"
                + "`passport`,"
                + "`address`,"
                + "`pol`,"
                + "`telefon`)"
                + "VALUES"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getFio());
            st.setString(2, value.getPassport());
            st.setString(3, value.getAddress());
            st.setString(4, value.getPol());
            st.setString(5, value.getTelefon());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Person value) {
        String sql = "DELETE FROM `student-gibdd`.`person`"
                + "WHERE id = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, value.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Person value) {
        String sql = "UPDATE `student-gibdd`.`person`"
                + "SET"
                + "`fio` = ?,"
                + "`passport` = ?,"
                + "`address` = ?,"
                + "`pol` = ?,"
                + "`telefon` = ?"
                + "WHERE `id` = ?;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, value.getFio());
            st.setString(2, value.getPassport());
            st.setString(3, value.getAddress());
            st.setString(4, value.getPol());
            st.setString(5, value.getTelefon());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Person findById(Integer id) {
        Person person = new Person();
        String sql = "SELECT * FROM `student-gibdd`.`person`"
                + "WHERE id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                person.setId(rs.getInt("id"));
                person.setFio(rs.getString("fio"));
                person.setPassport(rs.getString("passport"));
                person.setAddress(rs.getString("address"));
                person.setPol(rs.getString("pol"));
                person.setTelefon(rs.getString("telefon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        String sql = "SELECT * FROM `student-gibdd`.`person`";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFio(rs.getString("fio"));
                person.setPassport(rs.getString("passport"));
                person.setAddress(rs.getString("address"));
                person.setPol(rs.getString("pol"));
                person.setTelefon(rs.getString("telefon"));
                result.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
