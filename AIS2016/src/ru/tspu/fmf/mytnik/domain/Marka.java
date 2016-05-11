package ru.tspu.fmf.mytnik.domain;

import java.util.Date;

public class Marka {
    private  Integer id;
    private String name;
    private String firma;
    private String markaCol;
    private String haracteristiki;
    private String kategoria;
    private String opisanie;
    private Date startVupusk;
    private Date stopVupusk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getMarkaCol() {
        return markaCol;
    }

    public void setMarkaCol(String markaCol) {
        this.markaCol = markaCol;
    }

    public String getHaracteristiki() {
        return haracteristiki;
    }

    public void setHaracteristiki(String haracteristiki) {
        this.haracteristiki = haracteristiki;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public Date getStartVupusk() {
        return startVupusk;
    }

    public void setStartVupusk(Date startVupusk) {
        this.startVupusk = startVupusk;
    }

    public Date getStopVupusk() {
        return stopVupusk;
    }

    public void setStopVupusk(Date stopVupusk) {
        this.stopVupusk = stopVupusk;
    }
}
