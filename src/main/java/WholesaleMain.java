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

        TransactionSystem ts = new TransactionSystem();
        SystemInputOutput io = new SystemInputOutput();
        io.initialize(ts);

    }

}
