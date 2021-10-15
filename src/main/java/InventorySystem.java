import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventorySystem {

    private ArrayList<Product> inventory;

    public InventorySystem(){
        this.inventory = new ArrayList<Product>();
    }

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    public void setInventory(Product item) {
        this.inventory.add(item);
    }

    public Customer createCustomer(String username, String password){
        Customer c = new Customer(username, password);
        return c;
    }

    public Administrator createAdministrator(String username, String password){
        Administrator a = new Administrator(username, password);
        return a;
    }

    public Product createProduct(String name, Double price, int stock){
        Product p = new Product(name,price,stock);
        return p;
    }


    public List<String> productList(){
        ArrayList<String> list = new ArrayList<>();
        for (Product p : this.inventory){
            list.add(p.getName());
        }
        return list;
    }

    public Boolean availability(String name){
        return this.productList().contains(name);
    }

    public Product findProduct(String name){
        for (Product p : this.inventory){
            if (Objects.equals(p.getName(), name)){
                return p;
            }
        }
        return null;
    }

    public String addToCart(Customer c, String name, int quantity){
            if (this.availability(name)){
                Product p = findProduct(name);
                if (p != null && quantity <= p.getStock()){
                    c.add(p, quantity);
                    p.setStock(-quantity);
                    return "You have added " + quantity + "x of " + p.getName() + "at $" + p.getPrice() + " each.";
                }
            }
            return "The item is not available or there is not enough stock to fulfill your request.";
        }

    public String customerTotal(Customer c){
        double total = c.cartTotal();
        double rounded = Math.round(total * 100.0) / 100.0;
        return "Your total is $" + rounded;
    }


}
