package ui;

import entities.Product;
import gateway.DatabaseGateway;
import prompts.PromptIterator;
import transactions.TransactionSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI{


    public void initializeMenu() throws IOException, ClassNotFoundException {

        PromptIterator menuPrompts = new PromptIterator(new File("src/main/java/prompts/menu_prompts.txt"));

        while (menuPrompts.hasNext()) {
            System.out.println(menuPrompts.next());
            }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                PromptIterator categoryPrompts = new PromptIterator(new File("src/main/java/prompts/product_category_prompts.txt"));
                while (categoryPrompts.hasNext()) {
                    System.out.println(categoryPrompts.next());
                }
                ProductListUI productListUI = new ProductListUI();
                productListUI.createCategories();
                int categoryChoice = scanner.nextInt();
                productListUI.productCategory(categoryChoice);
                break;

            case 2:
                SystemInputOutput io = new SystemInputOutput();
                DatabaseGateway gateway = new DatabaseGateway();
                TransactionSystem ts = new TransactionSystem(gateway);
                io.initialize(ts);
        }
    }



}
