package transactions;

import database.DatabaseInput;
import users.Administrator;
import users.Customer;
import uses.UserManager;
import uses.InventorySystem;

import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    private final InventorySystem inventorySystem = new InventorySystem();
    private final DatabaseInput db = new DatabaseInput();
    private final UserManager um = new UserManager();


    public ArrayList<String> initializeTransaction(List<String> responses, String choice) {

        db.inputData(inventorySystem);

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
            String cartAction = inventorySystem.addToCart(c, responses.get(2), Integer.parseInt(responses.get(3)));
            String total = inventorySystem.customerTotal(c);


            if (inventorySystem.findProduct(responses.get(2)) != null){
                if (inventorySystem.findProduct(responses.get(2)).getStock() > 0){
                    String name = responses.get(2);
                    double price = inventorySystem.findProduct(responses.get(2)).getPrice();
                    int stock = inventorySystem.findProduct(responses.get(2)).getStock();
                    db.writeDatabase(name, price, stock);
                }
            }

            ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(cartAction);
            output.add(total);
            return output;
            }
        catch (IndexOutOfBoundsException ignored) {
        }

        return null;
    }

    public ArrayList<String> administratorTransaction(List<String> responses) {
        try {
            Administrator a = um.createAdministrator(responses.get(0), responses.get(1));
            String inventoryAction = inventorySystem.addToInventory(a, responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            db.writeDatabase(responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(inventoryAction);
            return output;
        }
        catch (IndexOutOfBoundsException ignored) {
        }

        return null;
    }

}
