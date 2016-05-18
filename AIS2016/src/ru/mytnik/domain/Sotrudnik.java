package ru.mytnik.domain;

public class Sotrudnik{
    private Integer id;
    private Integer idZvanie;
    private Integer idDolzhnost;
    private Integer idPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdZvanie() {
        return idZvanie;
    }

    public void setIdZvanie(Integer idZvanie) {
        this.idZvanie = idZvanie;
    }

    public Integer getIdDolzhnost() {
        return idDolzhnost;
    }

    public void setIdDolzhnost(Integer idDolzhnost) {
        this.idDolzhnost = idDolzhnost;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
}
