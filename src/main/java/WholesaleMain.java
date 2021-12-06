import ui.MenuUI;

import java.io.IOException;

public class WholesaleMain {

    /**
     * Main method which serves as the entry point to the program.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuUI ui = MenuUI.getInstance();
        ui.initializeMenu();
    }


}