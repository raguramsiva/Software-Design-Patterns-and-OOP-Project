import java.util.HashMap;

public class Customer extends User{

    HashMap<String, Integer> shoppingCart;

    public Customer(String username, String password) {
        super(username, password);
        this.shoppingCart = new HashMap<String,Integer>();

    }

    public Boolean add(Product item, int quantity){
        if (quantity <= item.getStock()){
            this.shoppingCart.put(item.getName(), quantity);
            item.setStock(-quantity);
            return true;
        }
        return false;
    }







}
