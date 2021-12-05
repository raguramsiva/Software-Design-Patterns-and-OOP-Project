package transactions;

import gateway.DatabaseGatewayBoundary;
import uses.ApplyMembership;
import uses.UserManager;
import uses.InventorySystem;
import users.Administrator;
import users.Customer;

import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    private final DatabaseGatewayBoundary gateway;
    private final InventorySystem inventorySystem = new InventorySystem();
    private final UserManager um = new UserManager();

    public TransactionSystem(DatabaseGatewayBoundary gateway) {
        this.gateway = gateway;
    }


    /**
     * A method to initialize a transaction.
     *
     * @param responses list of a user inputs.
     * @param choice    A string indicating user type (customer or administrator).
     * @return A list of strings representing transaction messages.
     */
    public ArrayList<String> initializeTransaction(List<String> responses, String choice) {

        gateway.inputDatabase(inventorySystem);

        if (choice.equalsIgnoreCase("customer")) {
            CustomerTransaction c = new CustomerTransaction();
            return c.createTransaction(gateway, inventorySystem, um, responses);
        }

        if (choice.equalsIgnoreCase("administrator")) {
            AdministratorTransaction a = new AdministratorTransaction();
            return a.createTransaction(gateway, inventorySystem, um, responses);
        }

        return null;
    }


}
