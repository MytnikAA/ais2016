package ru.tspu.fmf.mytnik.domain;

public class Zvanie {
    private Integer id;
    private String name;
    private Integer nadbavka;
    private String obiazanost;
    private String trebovanija;

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

    public Integer getNadbavka() {
        return nadbavka;
    }

    public void setNadbavka(Integer nadbavka) {
        this.nadbavka = nadbavka;
    }

    public String getObiazanost() {
        return obiazanost;
    }

    public void setObiazanost(String obiazanost) {
        this.obiazanost = obiazanost;
    }

    public String getTrebovanija() {
        return trebovanija;
    }

    public void setTrebovanija(String trebovanija) {
        this.trebovanija = trebovanija;
    }
}
