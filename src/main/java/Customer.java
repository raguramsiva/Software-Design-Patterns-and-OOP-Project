import java.util.HashMap;

public class Customer extends User{

    HashMap<Product, Integer> shoppingCart;

    boolean isMember = false;
    Member Membership;


    public Customer(String username, String password) {
        super(username, password);
        this.shoppingCart = new HashMap<Product,Integer>();

    }

    /**
     * @param item
     * @param quantity
     * @return
     */
    public Boolean addToCart(Product item, int quantity){
        if (quantity <= item.getStock()){
            item.setStock(-quantity);
            this.shoppingCart.put(item, quantity);
            return true;
        }
        return false;
    }


    public double cartTotal(){
        double total = 0;
        for (Product item : this.shoppingCart.keySet()){
            int quantity = this.shoppingCart.get(item);
            double price = item.getPrice();
            total += price * quantity;
        }
        return total;
    }

    private void RegisterMember(String memberNumber, String validDate, String expireDate,
                                String mobil, String paymentMethod, String address){
        Member Membership = new Member(memberNumber, validDate, expireDate, mobil, paymentMethod, address);
        isMember = true;
    }







}
