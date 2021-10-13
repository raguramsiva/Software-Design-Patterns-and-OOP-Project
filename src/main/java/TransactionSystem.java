import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    public void initialize(InputOutput io) {

        List<String> temp = new ArrayList<>();

        io.sendOutput("Type 'customer' or 'administrator' to continue. Type 'exit' to quit");
        try {
            String input = io.getInput();
            while (!input.equals("exit")) {
                if (input.equals("customer") || input.equals("administrator")) {
                    temp.add(input);
                    break;
                }
                input = io.getInput();
            }


        } catch (IOException e) {
            io.sendOutput("An error has occurred. Please restart the program. ");
        }





    }

    

    
}
