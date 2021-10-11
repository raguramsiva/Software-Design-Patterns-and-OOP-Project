import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    public interface InputOutput {
        String getInput() throws IOException;

        void sendOutput(Object s);
    }
    
    public void initialize(InputOutput inOut) {

        List<String> commandlinePrompts = new ArrayList<>();

        commandlinePrompts.add("Enter a username");
        commandlinePrompts.add("Enter a password");
        commandlinePrompts.add("Would you like to see a list of products available?");
        commandlinePrompts.add("Enter a username");


        List<String> userInputs = new ArrayList<>();

        inOut.sendOutput("Welcome! Type 'enter' to begin or 'exit' to quit.");

    }

    
}
