import gateway.DatabaseGateway;
import transactions.TransactionSystem;
import ui.MenuUI;
import ui.SystemInputOutput;

import java.io.IOException;

public class WholesaleMain {

    /**
     * Main method which serves as the entry point to the program.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuUI ui = new MenuUI();
        ui.initializeMenu();
    }

}
