package Transactions;

import Database.DatabaseInput;
import Users.Administrator;
import Users.Customer;
import Uses.UserManager;
import Uses.InventorySystem;

import java.util.ArrayList;
import java.util.List;



public class TransactionSystem {

    private InventorySystem insys = new InventorySystem();
    private DatabaseInput db = new DatabaseInput();
    private UserManager um = new UserManager();


    public ArrayList<String> initializeTransaction(List<String> responses, String choice) {

        db.inputData(insys);

        if (choice.equalsIgnoreCase("customer")) {
            return customerTransaction(responses);
        }

        if (choice.equalsIgnoreCase("administrator")) {
            return administratorTransaction(responses);
        }

        return null;

    }

    public ArrayList<String> customerTransaction(List<String> responses) {
        try {
            Customer c = um.createCustomer(responses.get(0), responses.get(1));
            String cartAction = insys.addToCart(c, responses.get(2), Integer.parseInt(responses.get(3)));
            String total = insys.customerTotal(c);
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(cartAction);
            output.add(total);
            return output;
            }
        catch (IndexOutOfBoundsException e) {
        }

        return null;
    }

    public ArrayList<String> administratorTransaction(List<String> responses) {
        try {
            Administrator a = um.createAdministrator(responses.get(0), responses.get(1));
            String inventoryAction = insys.addToInventory(a, responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(inventoryAction);
            return output;
        }
        catch (IndexOutOfBoundsException e) {
        }

        return null;
    }

}
