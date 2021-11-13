import Entities.Product;
import Users.Customer;
import Users.Administrator;
import Uses.InventorySystem;
import org.junit.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventorySystemTest {


    Product item1 = new Product("apple",0.50,5000);
    Product item2 = new Product("orange",1.00,3000);
    Product item3 = new Product("banana",1.50,4000);

    InventorySystem inventorySystem = new InventorySystem();
    Customer c = new Customer("user1234", "pass67!");
    Administrator a = new Administrator("bob10", "412313!");

    @Test
    public void productListTest() {
        inventorySystem.setInventory(item1);
        inventorySystem.setInventory(item3);
        List<String> products = inventorySystem.productList();
        assertEquals(true, products.contains(item1.getName()));
        assertEquals(false, products.contains(item2.getName()));
        assertEquals(true, products.contains(item3.getName()));

    }

    @Test
    public void addToInventoryTest(){
        String name = "Vanilla Ice Cream";
        double price = 2.99;
        int quantity = 100;

        String expected = "Product - " + name + " has been successfully added to inventory with price $" + inventorySystem.round(price) + " and quantity " + quantity + ".";
        String actual = inventorySystem.addToInventory(a, name, price, quantity);

        assertEquals(expected, actual);
    }




}