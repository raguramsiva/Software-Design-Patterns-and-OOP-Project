import java.util.ArrayList;

public class InventorySystem {

    private static ArrayList<Product> inventory;
    private Administrator admin;
    private Customer customer;

    public InventorySystem(Administrator admin){
        inventory = new ArrayList<>();
        this.admin = admin;
    }

    public InventorySystem(Customer customer){
        inventory = new ArrayList<>();
        this.customer = customer;
    }

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    public void setInventory(Product item) {
        this.inventory.add(item);
    }

}
