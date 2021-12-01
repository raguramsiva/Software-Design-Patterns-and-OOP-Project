import gateway.DatabaseGateway;
import prompts.PromptIterator;
import transactions.TransactionSystem;
import ui.SystemInputOutput;

import java.io.IOException;

public class WholesaleMain {

    /**
     * Main method of program creates instances of Transactions.TransactionSystem and UI.SystemInputOutput
     * Calls the initialize method of UI.SystemInputOutput using the instance of Transactions.TransactionSystem
     * as parameter.
     */
    public static void main(String[] args) throws IOException {

        SystemInputOutput io = new SystemInputOutput();
        DatabaseGateway gateway = new DatabaseGateway();
        TransactionSystem ts = new TransactionSystem(gateway);
        io.initialize(ts);

    }

}
