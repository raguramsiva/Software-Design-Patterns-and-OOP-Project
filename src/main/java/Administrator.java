public class Administrator extends User{


    /** An initializer for Administrator
     * @param username Administrator's username
     * @param password Administrator's password
     */
    public Administrator(String username, String password) {
        super(username, password);
    }


    /** Creates a product.
     * @param name product name
     * @param price product price
     * @param stock stock quantity
     * @return Product
     */
    public Product createProduct(String name, Double price, int stock){
        return new Product(name,price,stock);
    }




    }



