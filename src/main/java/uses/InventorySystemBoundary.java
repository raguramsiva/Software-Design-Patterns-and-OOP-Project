package uses;

import entities.Product;
import users.Administrator;
import users.Customer;

import java.util.ArrayList;
import java.util.List;

public interface InventorySystemBoundary {
    /**
     * Setter method for inventory.
     *
     * @param item The product to be added to inventory.
     */
    void setInventory(Product item);

    /**
     * Creates a product.
     *
     * @param name  product name
     * @param price product price
     * @param stock stock quantity
     * @return Entities.Product
     */
    Product createProduct(String name, Double price, int stock);

    /**
     * Creates a list of all the product names in the inventory.
     *
     * @return A list of product names in the inventory.
     */
    List<String> productList();

    /**
     * Checks whether a string is the name of a product in the inventory.
     *
     * @param name product name
     * @return Boolean (True if string is a name of a product in inventory; false otherwise)
     */
    Boolean availability(String name);

    /**
     * Finds the product associated with a product name, if it exists.
     *
     * @param name product name
     * @return product associated with name; null otherwise
     */
    Product findProduct(String name);

    /**
     * @param amount A double representing a monetary value.
     * @return amount rounded to two decimal places to represent a monetary value
     * in dollars and cents.
     */
    String round(double amount);

    /**
     * Adds a specified quantity of product to a customer's cart if the product is
     * available and in stock.
     *
     * @param c        A customer
     * @param name     A product name
     * @param quantity Desired quantity
     * @return String message
     */
    String addToCart(Customer c, String name, int quantity);

    /**
     * A method to return an array list of strings containing product information
     *
     * @return An array list of strings
     */
    ArrayList<ArrayList<Object>> productStringList();

    /**
     * Returns the customer's cart total.
     *
     * @param c A customer
     * @return Total
     */
    String customerTotal(Customer c);

    /**
     * Allows an administrator to add a product to the inventory.
     *
     * @param a        An administrator
     * @param name     A product name
     * @param price    A price
     * @param quantity A stock quantity
     * @return String message.
     */
    String addToInventory(Administrator a, String name, double price, int quantity);
}
