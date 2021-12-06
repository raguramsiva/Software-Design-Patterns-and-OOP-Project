package ui;

import database.DatabaseAccess;
import prompts.PromptIterator;
import controllers.TransactionSystem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuUI{

    public static final String PRESS_ANY_KEY = "Enter any key to return to the previous menu.";


    /**
     * A method to initialize the Main Menu.
     */
    public void initializeMenu() throws IOException, ClassNotFoundException {

        PromptIterator menuPrompts = new PromptIterator(new File("src/main/java/prompts/menu_prompts.txt"));

        while (menuPrompts.hasNext()) {
            System.out.println(menuPrompts.next());
            }

        int choice = -1;

        Scanner scanner = new Scanner(System.in);

        while (choice <= 0){
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    initializeProductListUI();
                    System.out.println(PRESS_ANY_KEY);
                    scanner.next();
                    initializeMenu();
                    break;

                case 2:
                    initializeSystemIO();
                    break;
            }
        }




    }

    /**
     * A method to initialize the Product List UI
     */
    public void initializeProductListUI(){
        PromptIterator categoryPrompts = new PromptIterator(new File("src/main/java/prompts/product_category_prompts.txt"));
        while (categoryPrompts.hasNext()) {
            System.out.println(categoryPrompts.next());
        }
        ProductCategoryUI productCategoryUI = new ProductCategoryUI();
        productCategoryUI.createCategories();
        Scanner scanner = new Scanner(System.in);
        int categoryChoice = scanner.nextInt();
        productCategoryUI.productCategory(categoryChoice);
    }


    /**
     * A method to initialize SystemInputOutput
     */
    public void initializeSystemIO() throws IOException, ClassNotFoundException {
        SystemInputOutput io = new SystemInputOutput();
        DatabaseAccess gateway = new DatabaseAccess();
        TransactionSystem ts = new TransactionSystem(gateway);
        io.initialize(ts);
    }



}