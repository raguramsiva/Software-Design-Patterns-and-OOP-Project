import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    public void initialize(InputOutput inOut) {

        List<String> commandlinePrompts = new ArrayList<>();

        commandlinePrompts.add("Enter a username");
        commandlinePrompts.add("Enter a password");
        commandlinePrompts.add("Would you like to see a list of products available?");


        List<String> userInputs = new ArrayList<>();

        inOut.sendOutput("Welcome! Type 'enter' to begin or 'exit' to quit.");

    }

    
}
