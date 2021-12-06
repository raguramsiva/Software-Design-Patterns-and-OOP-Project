import entities.Product;
import users.Administrator;
import users.Customer;
import uses.InventorySystem;
import org.junit.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {


    Product item1 = new Product("apple",0.50,5000);
    Product item2 = new Product("orange",1.00,3000);
    Product item3 = new Product("banana",1.50,4000);

    InventorySystem inventorySystem = new InventorySystem();
    Administrator a = new Administrator("bob10", "412313!");

    @Test
    public void productListTest() {
        inventorySystem.setInventory(item1);
        inventorySystem.setInventory(item3);
        List<String> products = inventorySystem.productList();
        assertTrue(products.contains(item1.getName()));
        assertFalse(products.contains(item2.getName()));
        assertTrue(products.contains(item3.getName()));

    }

    @Test
    public void productAvailabilityTest1() {
        inventorySystem.setInventory(item1);
        assertTrue(inventorySystem.availability("apple"));
    }

    @Test
    public void productAvailabilityTest2() {
        inventorySystem.setInventory(item1);
        assertFalse(inventorySystem.availability("orange"));
    }

    @Test
    public void findProductTest1() {
        inventorySystem.setInventory(item1);
        assertEquals(inventorySystem.findProduct("apple"), item1);
    }

    @Test
    public void findProductTest21() {
        assertNull(inventorySystem.findProduct("apple"));
    }



    @Test
    public void addToInventoryTest(){
        String name = "Vanilla Ice Cream";
        double price = 2.99;
        int quantity = 100;

        String expected = "Product - " + name + " has been successfully added to inventory with price $" + inventorySystem.round(price) + " and quantity " + quantity + ". Action " +
                "was taken by administrator: " + a.getUsername();
        String actual = inventorySystem.addToInventory(a, name, price, quantity);

        assertEquals(expected, actual);
    }



}