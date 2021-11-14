import transactions.TransactionSystem;
import ui.SystemInputOutput;

import java.io.IOException;

public class WholesaleMain {

    /**
     * Main method of program creates instances of Transactions.TransactionSystem and UI.SystemInputOutput
     * Calls the initialize method of Transactions.TransactionSystem using the instance of UI.SystemInputOutput
     * as parameter.
     */
    public static void main(String[] args) throws IOException {

        TransactionSystem ts = new TransactionSystem();
        SystemInputOutput io = new SystemInputOutput();
        io.initialize(ts);

    }

}
