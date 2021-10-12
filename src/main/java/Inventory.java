import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    public void setInventory(Product item) {
        this.inventory.add(item);
    }

}
