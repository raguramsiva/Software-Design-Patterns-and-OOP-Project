import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class TransactionSystem {



    public ArrayList<String> initializeTransaction(List<String> responses) {


        InventorySystem insys = new InventorySystem();

        //Temporarily adding some default items in inventory. As the program develops, they
        // will be refactored accordingly using a database.
        insys.setInventory(insys.createProduct("apple", 1.00, 10000));
        insys.setInventory(insys.createProduct("banana", 0.50, 2000));
        insys.setInventory(insys.createProduct("orange", 0.50, 2000));


        //We have written the code for the Customer side first. We will write the code for administrator after
        //Phase 0

        UserManager um = new UserManager();




        try {
            if (Objects.equals(responses.get(0), "customer")) {
                Customer c = um.createCustomer(responses.get(1),responses.get(2));
                String cart = insys.addToCart(c, responses.get(3), Integer.parseInt(responses.get(4)));
                String total = insys.customerTotal(c);
                ArrayList<String> output = new ArrayList<>();
                output.add(cart);
                output.add(total);
                return output;
            }
        } catch (IndexOutOfBoundsException e) {
        }

        return null;




    }



}
