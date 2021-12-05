package transactions;

import gateway.DatabaseGatewayBoundary;
import users.User;
import uses.InventorySystem;
import uses.UserManager;


import java.util.ArrayList;
import java.util.List;

public interface TransactionFactory {

    /**
     * A method to create a user transaction.
     * @return A list of strings representing transaction messages.
     */
    ArrayList<String> createTransaction(DatabaseGatewayBoundary gw, InventorySystem is, UserManager um, List<String> responses);

}
