package com.example.willy.projet_ihm_android.data;

/**
 * Created by tanguinoche on 11/04/16.
 */
public class Reservation {

    Client client;
    Chair chair;
    String horaires;

    public Reservation(Client client, Chair chair) {
        this.client = client;
        this.chair = chair;
    }

    public Reservation(Client client, Chair chair, String horaires) {
        this.client = client;
        this.chair = chair;
        this.horaires = horaires;
    }

    public Client getClient() {
        return client;
    }

    public Chair getChair() {
        return chair;
    }

    public String getHoraires() {
        return horaires;
    }
}
