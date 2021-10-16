import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TransactionSystem {


    /** A method that takes user inputs from prompts to make transactions.
     * @param io InputOutput
     */
    public void initialize(InputOutput io) {

        List<String> responses = new ArrayList<>();

        io.sendOutput("Type 'customer' or 'administrator' to continue. ");
        try {
            String input;
            do {
                input = io.getInput();
                if (input.equals("customer") || input.equals("administrator")) {
                    responses.add(input);
                }
            }
            while (!input.equals("customer") && !input.equals("administrator"));
        } catch (IOException e) {
            io.sendOutput("Please restart the program.");
        }


        try {
            if (responses.get(0) != null) {
               PromptIterator prompts = new PromptIterator(new File("src/main/java/" + responses.get(0) + "_prompts.txt"));
                try {
                    io.sendOutput(prompts.next());
                    String input = io.getInput();
                    responses.add(input);
                    while (!input.equals("quit") && prompts.hasNext()) {
                        io.sendOutput(prompts.next());
                        input = io.getInput();
                        if (!input.equals("quit")) {
                            responses.add(input);
                        }
                    }
                } catch (IOException e) {
                    io.sendOutput("Please restart the program.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            io.sendOutput("Please restart the program.");
        }

        InventorySystem insys = new InventorySystem();
        //Temporarily adding some default items in inventory. As the program develops, they
        // will be refactored accordingly using a database.
        insys.setInventory(insys.createProduct("apple", 1.00, 10000));
        insys.setInventory(insys.createProduct("banana", 0.50, 2000));
        insys.setInventory(insys.createProduct("orange", 0.50, 2000));


        try {
            if (Objects.equals(responses.get(0), "customer")) {
                Customer c = insys.createCustomer(responses.get(1),responses.get(2));
                String cart = insys.addToCart(c, responses.get(3), Integer.parseInt(responses.get(4)));
                String total = insys.customerTotal(c);
                io.sendOutput("");
                io.sendOutput("Transaction Summary:");
                io.sendOutput(cart);
                io.sendOutput(total);
            }
        } catch (IndexOutOfBoundsException e) {
            io.sendOutput("Please restart the program.");
        }




    }



}
