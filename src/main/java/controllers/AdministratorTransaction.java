package controllers;

import database.DatabaseAccessBoundary;
import users.Administrator;
import uses.InventorySystemBoundary;
import uses.UserManager;


import java.util.ArrayList;
import java.util.List;

public class AdministratorTransaction implements TransactionFactory{


    /**
     * A method for an administrator transaction.
     *
     * @param responses A list of an administrator's inputs.
     * @return A list of strings representing an administrator's transaction messages.
     */
    @Override
    public ArrayList<String> createTransaction(DatabaseAccessBoundary gw, InventorySystemBoundary is, UserManager um, List<String> responses) {
        try {
            Administrator a = um.createAdministrator(responses.get(0), responses.get(1));
            String inventoryAction = is.addToInventory(a, responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            gw.writeDatabase(responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(inventoryAction);
            return output;
        } catch (IndexOutOfBoundsException ignored) {
        }

        return null;
    }
}
