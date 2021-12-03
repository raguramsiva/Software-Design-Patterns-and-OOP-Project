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
     * @param choice    A string indicating user type.
     * @return A list of strings representing transaction messages.
     */
    public ArrayList<String> initializeTransaction(List<String> responses, String choice) {

        gateway.inputData(inventorySystem);

        if (choice.equalsIgnoreCase("customer")) {
            return customerTransaction(responses);
        }

        if (choice.equalsIgnoreCase("administrator")) {
            return administratorTransaction(responses);
        }

        return null;

    }

    /**
     * A method for a customer transaction.
     *
     * @param responses A list of a customer's inputs.
     * @return A list of strings representing a customer's transaction messages.
     */
    public ArrayList<String> customerTransaction(List<String> responses) {
        try {
            ArrayList<String> output = new ArrayList<>();
            Customer c = um.createCustomer(responses.get(0), responses.get(1));
            if (CheckInVaildInput(responses, 7)) {
                output.add("Invalid membership input, please try again latter.");
                return output;
            }
            ApplyMembership apply = new ApplyMembership();
            apply.NewMembership(c, responses.get(4), responses.get(5), responses.get(6), responses.get(7));
            String cartAction = inventorySystem.addToCart(c, responses.get(2), Integer.parseInt(responses.get(3)));


            String cartMember = inventorySystem.addToCart(c, responses.get(7), 1);
            String total = inventorySystem.customerTotal(c);

            if (inventorySystem.findProduct(responses.get(2)) != null) {
                if (inventorySystem.findProduct(responses.get(2)).getStock() >= 0) {
                    String name = responses.get(2);
                    double price = inventorySystem.findProduct(responses.get(2)).getPrice();
                    int stock = inventorySystem.findProduct(responses.get(2)).getStock();
                    gateway.writeDatabase(name, price, stock);
                }
            }
            //ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(cartAction);
            output.add(cartMember);
            output.add(total);
            return output;
        } catch (IndexOutOfBoundsException ignored) {
        }

        return null;
    }

    /**
     * A method for an administrator transaction.
     *
     * @param responses A list of an administrator's inputs.
     * @return A list of strings representing an administrator's transaction messages.
     */
    public ArrayList<String> administratorTransaction(List<String> responses) {
        try {
            Administrator a = um.createAdministrator(responses.get(0), responses.get(1));
            String inventoryAction = inventorySystem.addToInventory(a, responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            gateway.writeDatabase(responses.get(2), Double.parseDouble(responses.get(3)), Integer.parseInt(responses.get(4)));
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            output.add("Transaction Summary:");
            output.add(inventoryAction);
            return output;
        } catch (IndexOutOfBoundsException ignored) {
        }

        return null;
    }


    /**
     * A method for input member type is valid.
     *
     * @param responses A list of an administrator's inputs.
     * @param IndexOfMember The index of the responses for the MemberShip
     * @return A boolean represent the validation of the input.
     */
    public boolean CheckInVaildInput(List<String> responses, int IndexOfMember) {
        return !responses.get(IndexOfMember).equals("Silver Membership") &&
                !responses.get(IndexOfMember).equals("Gold Membership") &&
                !responses.get(IndexOfMember).equals("Platinum Membership");
    }


}
