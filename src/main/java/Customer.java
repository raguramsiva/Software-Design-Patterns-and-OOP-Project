import java.util.HashMap;

public class Customer extends User{


    HashMap<Product, Integer> shoppingCart;


    /** An initializer for Customer. Each instance of customer has a personal shopping cart.
     * @param username A customer's username
     * @param password A customer's password
     */
    public Customer(String username, String password) {
        super(username, password);
        this.shoppingCart = new HashMap<>();

    }

    /** Adds a specified quantity of products to customer's shopping cart.
     * @param item a product
     * @param quantity number of products
     */
    public void add(Product item, int quantity){
        this.shoppingCart.put(item, quantity);
    }


    /** Calculates the total cost of a customer's shopping cart.
     * @return Total cost of customer's shopping cart.
     */
    public double cartTotal(){
        double total = 0;
        for (Product item : this.shoppingCart.keySet()){
            int quantity = this.shoppingCart.get(item);
            double price = item.getPrice();
            total += price * quantity;
        }
        return total;
    }




}
