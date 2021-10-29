import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SystemInputOutput implements InputOutput {

    BufferedReader reader;

    private List<String> responses = new ArrayList<>();

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

    public String chooseUser(){
        this.sendOutput("Type 'customer' or 'administrator' to continue. ");
        try {
            String input;
            do {
                input = this.getInput();
                if (input.equals("customer") || input.equals("administrator")) {
                    return input;
                }
            }
            while (!input.equals("customer") && !input.equals("administrator"));
        } catch (IOException e) {
            this.sendOutput("Please restart the program.");
        }
        return null;
    }

    public void promptAnswers(String fileName){
        PromptIterator prompts = new PromptIterator(new File("src/main/java/" + fileName + "_prompts.txt"));
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


    public void initialize(TransactionSystem ts) {
        String choice = chooseUser();
        responses.add(choice);

        try {
            if (Objects.equals(responses.get(0), "customer")) {
                promptAnswers(responses.get(0));
            }

            ArrayList<String> transaction = ts.initializeTransaction(responses);
            this.sendOutput("");
            this.sendOutput("Transaction Summary:");
            this.sendOutput(transaction.get(0));
            this.sendOutput(transaction.get(1));

        } catch (IndexOutOfBoundsException e) {
            this.sendOutput("Please restart the program.");
        }

    }


}

