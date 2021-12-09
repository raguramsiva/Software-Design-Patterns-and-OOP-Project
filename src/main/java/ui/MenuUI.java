package ui;

import controllers.UseCaseInjector;
import database.DatabaseAccess;
import prompts.PromptIterator;
import controllers.TransactionSystem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuUI{

    private static final MenuUI instance = new MenuUI();

    private MenuUI(){}

    /** A method to return a singleton (global instance) of MenuUI
     * @return global instance of MenuUI
     */
    public static MenuUI getInstance(){
        return instance;
    }

    public static final String PRESS_ANY_KEY = "Enter any key to return to the previous menu.";


    /**
     * A method to initialize the Main Menu.
     */
    public void initializeMenu(){

        PromptIterator menuPrompts = new PromptIterator(new File("src/main/java/prompts/menu_prompts.txt"));

        while (menuPrompts.hasNext()) {
            System.out.println(menuPrompts.next());
            }

        String choice = "";

        Scanner scanner = new Scanner(System.in);

        while (!choice.equals("0") && !choice.equals("1")){
            choice = scanner.next();
            try{
                int num = Integer.parseInt(choice);
                switch (num) {
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
            } catch (Exception ignore) {
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
        UseCaseInjector injector = new UseCaseInjector();
        TransactionSystem ts = new TransactionSystem(gateway, injector.injectInventory(), injector.injectUserManager());
        io.initialize(ts);
    }



}