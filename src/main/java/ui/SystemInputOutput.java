package ui;

import login.LoginSystem;
import controllers.TransactionSystem;
import prompts.PromptIterator;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SystemInputOutput implements InputOutput {

    private final LoginSystem loginSystem;
    BufferedReader reader;


    /**
     * An initializer for ui.SystemInputOutput.
     */
    public SystemInputOutput() throws IOException, ClassNotFoundException {
        this.loginSystem = new LoginSystem();
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


    /**
     * A method to initialize login system.
     */
    public void initializeLogin(){
        PromptIterator prompts = new PromptIterator(new File("src/main/java/Prompts/login_prompts.txt"));
        List<String> responses = getStrings(prompts);
        this.loginSystem.controller.runLogin(responses.get(0), responses.get(1));
    }


    /** A method to get user responses to provided prompts.
     * @param prompts a PromptIterator
     * @return A list of strings containing user responses.
     */
    private List<String> getStrings(PromptIterator prompts) {
        List<String> responses = new ArrayList<>();
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




    /** A method to select a user type.
     * @return A string indicating a user type.
     */
    public String chooseUser() throws IOException {
        this.sendOutput("\nType 'customer' or 'administrator' to continue. Type 'quit' to exit the program.");
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

    /** A method that outputs prompts to a user and gathers user inputted responses.
     * @param fileName A name of a file containing prompts.
     * @return A list of responses inputted by user.
     */
    public List<String> promptAnswers(String fileName){
        PromptIterator prompts = new PromptIterator(new File("src/main/java/Prompts/" + fileName + "_prompts.txt"));
        return getStrings(prompts);
    }


    /** A method to initialize a user transaction.
     * @param ts An instance of TransactionSystem
     */
    public void initialize(TransactionSystem ts) throws IOException {

        initializeLogin();
        String choice = chooseUser();
        List<String> responses = promptAnswers(choice);

        ArrayList<String> transaction = ts.initializeTransaction(responses, choice);

        for (String s : transaction) {
            this.sendOutput(s);
        }
        System.exit(0);


    }

}