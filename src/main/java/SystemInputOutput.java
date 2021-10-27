import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SystemInputOutput implements InputOutput {

    BufferedReader reader;


    /**
     * An initializer for SystemInputOutput.
     */
    public SystemInputOutput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    /** A method that gets input.
     * @return input
     */
    public String getInput() throws IOException {
        return this.reader.readLine();
    }

    /** A method that prints an output. 
     * @param s output
     */
    @Override
    public void sendOutput(Object s) {
        System.out.println(s);
    }


    public void initialize(TransactionSystem ts) {

        List<String> responses = new ArrayList<>();

        this.sendOutput("Type 'customer' or 'administrator' to continue. ");
        try {
            String input;
            do {
                input = this.getInput();
                if (input.equals("customer") || input.equals("administrator")) {
                    responses.add(input);
                }
            }
            while (!input.equals("customer") && !input.equals("administrator"));
        } catch (IOException e) {
            this.sendOutput("Please restart the program.");
        }

        try {
            if (Objects.equals(responses.get(0), "customer")) {
                PromptIterator prompts = new PromptIterator(new File("src/main/java/" + responses.get(0) + "_prompts.txt"));
                try {
                    this.sendOutput(prompts.next());
                    String input = this.getInput();
                    responses.add(input);
                    while (!input.equals("quit") && prompts.hasNext()) {
                        this.sendOutput(prompts.next());
                        input = this.getInput();
                        if (!input.equals("quit")) {
                            responses.add(input);
                        }
                    }
                } catch (IOException e) {
                    this.sendOutput("Please restart the program.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            this.sendOutput("Please restart the program.");
        }

        ArrayList<String> transactions = ts.initializeTransaction(responses);
        this.sendOutput("");
        this.sendOutput("Transaction Summary:");
        this.sendOutput(transactions.get(0));
        this.sendOutput(transactions.get(1));


    }


}

