public class Product {

    private String name;
    private double price;
    private int stock;

    /** Initializer for Product.
     * @param name A name
     * @param price a price
     * @param stock A stock quantity
     */
    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /** Getter method for Product.
     * @return product name
     */
    public String getName() {
        return this.name;
    }

    /** Getter method for price
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /** Setter method for price
     * @return price
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }


    /** Getter method for stock quantity
     * @return stock quantity
     */
    public int getStock() {
        return this.stock;
    }


    /** Setter method for stock quantity
     * @return stock quantity
     */
    public void setStock(int quantity) {
        this.stock += quantity;
    }


}
