package com.example.willy.projet_ihm_android.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 10/04/16.
 */
public class DataController {

    private List<Client> clients;
    //private List<Command> commands
    private Restaurant restaurant;
    private List<Reservation> reservations;

    /** Constructeur privé */
    private DataController()
    {
        clients = new ArrayList<>();
        //commands = new ArrayList<>();
        restaurant = new Restaurant();
        reservations = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    /** Holder */
    private static class DataControllerHolder
    {
        /** Instance unique non préinitialisée */
        private final static DataController instance = new DataController();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static DataController getInstance()
    {
        return DataControllerHolder.instance;
    }

    public void addTables(Table ...tables) {
        for(Table table : tables)
            restaurant.getTables().add(table);
    }
    public void addTables(List<Table> tables) {
        restaurant.getTables().addAll(tables);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addCommand() {

    }

    public void changeChildClient(int id) {
        for(Client c: clients) {
            if(c.getId() == id) {
                c.setChildMode(!c.isChildMode());
            }
        }
    }

    public void addReservation(Client client, Chair chair) {
        if(!clients.contains(client))
            clients.add(client);
        reservations.add(new Reservation(client, chair));
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
