package entities;

import java.util.HashMap;

public class Cart{

    HashMap<Product, Integer> shoppingCart;

    /**
     * A constructor for Cart.
     */
    public Cart(){
        this.shoppingCart = new HashMap<>();
    }

    /** Getter method for shopping cart.
     * @return shopping Cart
     */
    public HashMap<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }


    /** Setter method for shopping cart.
     * @param item a product
     * @param quantity a specified integer quantity
     */
    public void setShoppingCart(Product item, int quantity) {
        this.shoppingCart.put(item, quantity);
    }
}
