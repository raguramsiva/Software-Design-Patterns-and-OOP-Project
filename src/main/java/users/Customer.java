package users;

import entities.Cart;
import entities.Product;

public class Customer extends User {


    private final Cart cart;


    /** An initializer for Users.Customer. Each instance of customer has a personal shopping cart.
     * @param username A customer's username
     * @param password A customer's password
     */
    public Customer(String username, String password) {
        super(username, password);
        this.cart = new Cart();

    }

    /** Adds a specified quantity of products to customer's shopping cart.
     * @param item a product
     * @param quantity number of products
     */
    public void add(Product item, int quantity){
        cart.setShoppingCart(item, quantity);
    }


    /** Calculates the total cost of a customer's shopping cart.
     * @return Total cost of customer's shopping cart.
     */
    public double cartTotal(){
        double total = 0;
        for (Product item : cart.getShoppingCart().keySet()){
            int quantity = cart.getShoppingCart().get(item);
            double price = item.getPrice();
            total += price * quantity;
        }
        return total;
    }




}
