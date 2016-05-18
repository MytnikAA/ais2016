package ru.mytnik.domain;

import java.util.Date;

public class Voditel {
    private Integer id;
    private String nomerVU;
    private Date vydacha;
    private String kategiria;
    private String opisanie;
    private Integer idPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomerVU() {
        return nomerVU;
    }

    public void setNomerVU(String nomerVU) {
        this.nomerVU = nomerVU;
    }

    public Date getVydacha() {
        return vydacha;
    }

    public void setVydacha(Date vydacha) {
        this.vydacha = vydacha;
    }

    public String getKategiria() {
        return kategiria;
    }

    public void setKategiria(String kategiria) {
        this.kategiria = kategiria;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
    
}
