import java.util.HashMap;

public class Customer extends User{


    private final Cart cart;


    /** An initializer for Customer. Each instance of customer has a personal shopping cart.
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
        cart.shoppingCart.put(item, quantity);
    }


    /** Calculates the total cost of a customer's shopping cart.
     * @return Total cost of customer's shopping cart.
     */
    public double cartTotal(){
        double total = 0;
        for (Product item : cart.shoppingCart.keySet()){
            int quantity = cart.shoppingCart.get(item);
            double price = item.getPrice();
            total += price * quantity;
        }
        return total;
    }




}
