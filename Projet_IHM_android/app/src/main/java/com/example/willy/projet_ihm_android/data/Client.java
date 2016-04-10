package com.example.willy.projet_ihm_android.data;

/**
 * Created by tanguinoche on 02/04/16.
 */
public class Client  {


    private static int cpt = 0;
    private final int id;
    private String name;
    private Chair idChair;
    private Table idTable;
    private Object[] panier;



    private boolean childMode = false;


    public Client() {
        this.id = ++cpt;
    }
    public Client(String name) {
        this.id = ++cpt;
        this.name = name;
    }
    public Client(Chair idChair, Table idTable) {
        this.id = ++cpt;
        this.idChair = idChair;
        this.idTable = idTable;
    }
    public Client(String name, Chair idChair, Table idTable) {
        this.id = ++cpt;
        this.name = name;
        this.idChair = idChair;
        this.idTable = idTable;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chair getIdChair() {
        return idChair;
    }

    public void setIdChair(Chair idChair) {
        this.idChair = idChair;
    }

    public Table getIdTable() {
        return idTable;
    }

    public void setIdTable(Table idTable) {
        this.idTable = idTable;
    }

    public Object[] getPanier() {
        return panier;
    }

    public void setPanier(Object[] panier) {
        this.panier = panier;
    }
    public boolean isChildMode() {
        return childMode;
    }

    public void setChildMode(boolean childMode) {
        this.childMode = childMode;
    }
}
