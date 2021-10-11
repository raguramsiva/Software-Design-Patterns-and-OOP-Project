import java.util.TreeSet;

public class WholesaleStore {

    private static TreeSet<Product> inventory;

    public TreeSet<Product> getInventory() {
        return this.inventory;
    }

    public void setInventory(Product item) {
        this.inventory.add(item);
    }



    public static void main(String[] args) {

        TransactionSystem ts = new TransactionSystem();
        SystemInputOutput inputOutput = new SystemInputOutput();
        ts.initialize(inputOutput);

    }



}
