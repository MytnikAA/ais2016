package ru.tspu.fmf.mytnik.domain;

import java.util.Date;

public class Avto {
    private Integer id;
    private String nomer;
    private String nomerKyzova;
    private String nomerDvigla;
    private String nomerTP;
    private Date vypusk;
    private Date reg;
    private String color;
    private String TO;
    private Date dateTO;
    private String opisanie;
    private Integer idMarka;
    private Integer idVladelets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getNomerKyzova() {
        return nomerKyzova;
    }

    public void setNomerKyzova(String nomerKyzova) {
        this.nomerKyzova = nomerKyzova;
    }

    public String getNomerDvigla() {
        return nomerDvigla;
    }

    public void setNomerDvigla(String nomerDvigla) {
        this.nomerDvigla = nomerDvigla;
    }

    public String getNomerTP() {
        return nomerTP;
    }

    public void setNomerTP(String nomerTP) {
        this.nomerTP = nomerTP;
    }

    public Date getVypusk() {
        return vypusk;
    }

    public void setVypusk(Date vypusk) {
        this.vypusk = vypusk;
    }

    public Date getReg() {
        return reg;
    }

    public void setReg(Date reg) {
        this.reg = reg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
    }

    public Date getDateTO() {
        return dateTO;
    }

    public void setDateTO(Date dateTO) {
        this.dateTO = dateTO;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public Integer getIdMarka() {
        return idMarka;
    }

    public void setIdMarka(Integer idMarka) {
        this.idMarka = idMarka;
    }

    public Integer getIdVladelets() {
        return idVladelets;
    }

    public void setIdVladelets(Integer idVladelets) {
        this.idVladelets = idVladelets;
    }

    
}
