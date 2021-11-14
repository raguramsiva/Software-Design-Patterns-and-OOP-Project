package ui;

import transactions.TransactionSystem;
import prompts.PromptIterator;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SystemInputOutput implements InputOutput {

    BufferedReader reader;


    /**
     * An initializer for ui.SystemInputOutput.
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


    public String chooseUser() throws IOException {
        this.sendOutput("Type 'customer' or 'administrator' to continue. Type 'quit' to exit the program.");
        String input = "";
        while (!input.equalsIgnoreCase("customer") && !input.equalsIgnoreCase("administrator")) {
            if (input.equalsIgnoreCase("quit")){
                this.sendOutput("\nThank you, come again!");
                System.exit(0);
            }
            input = this.getInput();
        }
        return input;
    }

    public List<String> promptAnswers(String fileName){
        List<String> responses = new ArrayList<>();
        PromptIterator prompts = new PromptIterator(new File("src/main/java/Prompts/" + fileName + "_prompts.txt"));
        try {
            this.sendOutput(prompts.next());
            String input = this.getInput();
            responses.add(input);
            while (!input.equalsIgnoreCase("quit") && prompts.hasNext()) {
                this.sendOutput(prompts.next());
                input = this.getInput();
                if (!input.equalsIgnoreCase("quit")) {
                    responses.add(input);
                }
            }
        } catch (IOException e) {
            this.sendOutput("Please restart the program.");
        }
        return responses;
    }


    public void initialize(TransactionSystem ts) throws IOException {

        String choice = chooseUser();
        List<String> responses = promptAnswers(choice);

        ArrayList<String> transaction = ts.initializeTransaction(responses, choice);

        for (String s : transaction) {
            this.sendOutput(s);
        }


    }

}




