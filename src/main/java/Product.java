public class Product {

    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int quantity) {
        this.stock += quantity;
    }


}
