package ru.mytnik.domain;

public class Dolzhnost {
    private Integer id;
    private String name;
    private Integer oklad;
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

    public Integer getOklad() {
        return oklad;
    }

    public void setOklad(Integer oklad) {
        this.oklad = oklad;
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
