import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TransactionSystem {

    public interface InputOutput {
        String getInput() throws IOException;

        void sendOutput(Object s);
    }
    
    public void initialize(InputOutput inOut) {

        List<String> temp = new ArrayList<>();

        inOut.sendOutput("Welcome! Type 'enter' to begin or 'exit' to quit.");

    }

    
}
