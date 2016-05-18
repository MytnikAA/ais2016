package ru.mytnik.dao;

import java.sql.Connection;
import java.util.Properties;
import ru.mytnik.db.MySQLConnector;
import ru.mytnik.domain.Avto;
import ru.mytnik.domain.Dolzhnost;
import ru.mytnik.domain.GTA;
import ru.mytnik.domain.Marka;
import ru.mytnik.domain.Person;
import ru.mytnik.domain.Sotrudnik;
import ru.mytnik.domain.Voditel;
import ru.mytnik.domain.Zvanie;

public class DAOFabric {

    public static DAOInterface getInstance(Class type) {
        if (Avto.class.equals(type)) {
            DAOInterface<Avto> dao = new AvtoDAO(connect());
            return dao;
        }
        if (Dolzhnost.class.equals(type)) {
            DAOInterface<Dolzhnost> dao = new DolzhnostDAO(connect());
            return dao;
        }
        if (GTA.class.equals(type)) {
            DAOInterface<GTA> dao = new GTADAO(connect());
            return dao;
        }
        if (Marka.class.equals(type)) {
            DAOInterface<Marka> dao = new MarkaDAO(connect());
            return dao;
        }
        if (Person.class.equals(type)) {
            DAOInterface<Person> dao = new PersonDAO(connect());
            return dao;
        }
        if (Sotrudnik.class.equals(type)) {
            DAOInterface<Sotrudnik> dao = new SotrudnikDAO(connect());
            return dao;
        }
        if (Voditel.class.equals(type)) {
            DAOInterface<Voditel> dao = new VoditelDAO(connect());
            return dao;
        }
        if (Zvanie.class.equals(type)) {
            DAOInterface<Zvanie> dao = new ZvanieDAO(connect());
            return dao;
        }
        return null;
    }

    private static Connection connect() {
        MySQLConnector connector = new MySQLConnector();
        Properties dbSettings = new Properties();
        dbSettings.setProperty("db.host", "stddb.mytnik.ru");
        dbSettings.setProperty("db.name", "student-gibdd");
        dbSettings.setProperty("db.user", "std");
        dbSettings.setProperty("db.password", "std123");
        connector.setDbSettings(dbSettings);
        return connector.getDBConnect();
    }

}
