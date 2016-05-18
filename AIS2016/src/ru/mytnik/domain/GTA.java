package ru.mytnik.domain;

import java.util.Date;

public class GTA {
    private Integer id;
    private Date ugon;
    private Date obraschenia;
    private String obstoiatelstva;
    private Boolean otmetkaNahodki;
    private Date dateNahodki;
    private Integer idAvto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUgon() {
        return ugon;
    }

    public void setUgon(Date ugon) {
        this.ugon = ugon;
    }

    public Date getObraschenia() {
        return obraschenia;
    }

    public void setObraschenia(Date obraschenia) {
        this.obraschenia = obraschenia;
    }

    public String getObstoiatelstva() {
        return obstoiatelstva;
    }

    public void setObstoiatelstva(String obstoiatelstva) {
        this.obstoiatelstva = obstoiatelstva;
    }

    public Boolean getOtmetkaNahodki() {
        return otmetkaNahodki;
    }

    public void setOtmetkaNahodki(Boolean otmetkaNahodki) {
        this.otmetkaNahodki = otmetkaNahodki;
    }

    public Date getDateNahodki() {
        return dateNahodki;
    }

    public void setDateNahodki(Date dateNahodki) {
        this.dateNahodki = dateNahodki;
    }

    public Integer getIdAvto() {
        return idAvto;
    }

    public void setIdAvto(Integer idAvto) {
        this.idAvto = idAvto;
    }
    
    
}
