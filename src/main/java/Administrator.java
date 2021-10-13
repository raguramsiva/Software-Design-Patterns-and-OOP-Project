public class Administrator extends User{


    public Administrator(String username, String password) {
        super(username, password);
    }

    public void addToInventory(Product newProduct, Inventory inputInventory){
        inputInventory.setInventory(newProduct);
    }






    }



