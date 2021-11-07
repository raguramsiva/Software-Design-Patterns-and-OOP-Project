package Entities;

import Entities.Product;

import java.util.HashMap;

public class Cart{

    HashMap<Product, Integer> shoppingCart;

    public Cart(){
        this.shoppingCart = new HashMap<>();
    }

    public HashMap<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Product item, int quantity) {
        this.shoppingCart.put(item, quantity);
    }
}
