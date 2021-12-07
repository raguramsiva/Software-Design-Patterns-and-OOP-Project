package controllers;

import database.DatabaseAccessBoundary;
import uses.InventorySystemBoundary;
import uses.UserManagerBoundary;

import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    private final DatabaseAccessBoundary gateway;
    private final InventorySystemBoundary inventorySystemBoundary;
    private final UserManagerBoundary um;

    public TransactionSystem(DatabaseAccessBoundary gateway, InventorySystemBoundary inventorySystemBoundary, UserManagerBoundary um) {
        this.gateway = gateway;
        this.inventorySystemBoundary = inventorySystemBoundary;
        this.um = um;
    }


    /**
     * A method to initialize a transaction.
     *
     * @param responses list of a user inputs.
     * @param choice  A string indicating user type (customer or administrator).
     * @return A list of strings representing transaction messages.
     */
    public ArrayList<String> initializeTransaction(List<String> responses, String choice) {

        gateway.inputDatabase(inventorySystemBoundary);

        if (choice.equalsIgnoreCase("customer")) {
            CustomerTransaction c = new CustomerTransaction();
            return c.createTransaction(gateway, inventorySystemBoundary, um, responses);
        }

        if (choice.equalsIgnoreCase("administrator")) {
            AdministratorTransaction a = new AdministratorTransaction();
            return a.createTransaction(gateway, inventorySystemBoundary, um, responses);
        }

        return null;
    }


}
