package controllers;

import database.DatabaseAccessBoundary;
import uses.InventorySystemBoundary;
import uses.UserManagerBoundary;


import java.util.ArrayList;
import java.util.List;

public interface TransactionFactory {

    /**
     * A method to create a user transaction.
     * @return A list of strings representing transaction messages.
     */
    ArrayList<String> createTransaction(DatabaseAccessBoundary gw, InventorySystemBoundary is, UserManagerBoundary um, List<String> responses);

}
