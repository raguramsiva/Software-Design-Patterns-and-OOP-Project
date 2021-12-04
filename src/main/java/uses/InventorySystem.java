package uses;

import entities.Product;
import users.Administrator;
import users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventorySystem {

    private final ArrayList<Product> inventory;


    /**
     * An initializer for uses.InventorySystem.
     */
    public InventorySystem(){
        this.inventory = new ArrayList<>();
    }

    /** Setter method for inventory.
     * @param item The product to be added to inventory.
     */
    public void setInventory(Product item) {
        this.inventory.add(item);
    }


    /** Creates a product.
     * @param name product name
     * @param price product price
     * @param stock stock quantity
     * @return Entities.Product
     */
    public Product createProduct(String name, Double price, int stock){
        return new Product(name,price,stock);
    }


    /** Creates a list of all the product names in the inventory.
     * @return A list of product names in the inventory.
     */
    public List<String> productList(){
        ArrayList<String> list = new ArrayList<>();
        for (Product p : this.inventory){
            list.add(p.getName());
        }
        return list;
    }

    /** Checks whether a string is the name of a product in the inventory.
     * @param name product name
     * @return Boolean (True if string is a name of a product in inventory; false otherwise)
     */
    public Boolean availability(String name){
        return this.productList().contains(name);
    }


    /** Finds the product associated with a product name, if it exists.
     * @param name product name
     * @return product associated with name; null otherwise
     */
    public Product findProduct(String name){
        for (Product p : this.inventory){
            if (Objects.equals(p.getName(), name)){
                return p;
            }
        }
        return null;
    }

    /**
     * @param amount A double representing a monetary value.
     * @return amount rounded to two decimal places to represent a monetary value
     * in dollars and cents.
     */
    public String round(double amount){
        int multiple = (int) (100 * amount);
        String str = String.valueOf(multiple);
        String dollars = str.substring(0, str.length()-2);
        String cents = str.substring(str.length()-2);

        if (dollars.equals("")){
            return "0." + cents;
        }
        return dollars + "." + cents;
    }

    /** Adds a specified quantity of product to a customer's cart if the product is
     * available and in stock.
     * @param c A customer
     * @param name A product name
     * @param quantity Desired quantity
     * @return String message
     */
    public String addToCart(Customer c, String name, int quantity) {
        if (this.availability(name)) {
            Product p = findProduct(name);
            if (p != null && quantity <= p.getStock()) {
                c.add(p, quantity);
                p.setStock(-quantity);
                return "You have added " + quantity + " units of " + p.getName() + " priced at $" + round(p.getPrice()) + " each.";
            }
        }

        return "The item is not available or there is not enough stock to fulfill your request.";

    }

    public ArrayList<ArrayList<Object>> productStringList(){
        ArrayList<ArrayList<Object>> productStrings = new ArrayList<>();
        for (Product p : this.inventory){
            ArrayList<Object> temp = new ArrayList<>();
            temp.add(p.getName());
            temp.add("$" + round(p.getPrice()));
            temp.add(p.getStock());
            productStrings.add(temp);
        }
        return productStrings;

    }


    /** Returns the customer's cart total.
     * @param c A customer
     * @return Total
     */
    public String customerTotal(Customer c){
        double total = c.cartTotal();
        total = c.AfterMemberDiscount(total);
        if (total > 0){
            return "Your total after membership discount is $" + round(total) + ".";
        }
        return "Your total is $0.00" + ".";
    }


    /** Allows an administrator to add a product to the inventory.
     * @param a An administrator
     * @param name A product name
     * @param price A price
     * @param quantity A stock quantity
     * @return String message.
     */
    public String addToInventory(Administrator a, String name, double price, int quantity){
        if (!this.availability(name)){
            this.setInventory(createProduct(name, price, quantity));
            return "Product - " + name + " has been successfully added to inventory with price $" + round(price) + " and quantity " + quantity + ". Action " +
                    "was taken by administrator: " + a.getUsername();
        }
        else {
            Product p = findProduct(name);
            p.setStock(quantity);
            return "Product - " + name + " has been successfully modified in inventory with price $" + round(price) + " and quantity " + quantity + ".";
        }
    }





}
