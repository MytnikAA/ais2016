package ru.tspu.fmf.mytnik.domain;

import java.util.List;

public class Sotrudnik extends Person{
    private Integer id;
    private List<Dolzhnost> dolzhnostList;
    private Zvanie zvanie;
}
