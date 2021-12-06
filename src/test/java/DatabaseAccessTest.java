import database.DatabaseAccess;
import uses.InventorySystem;
import org.junit.Test;


import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseAccessTest {

    DatabaseAccess gateway = new DatabaseAccess();
    InventorySystem inventoryOne = new InventorySystem();
    InventorySystem inventoryTwo = new InventorySystem();


    @Test
    public void inputDatabaseTest() {
        gateway.inputData(new File("src/main/java/database/data/Fruits_and_Vegetables.json"), inventoryOne);
        assertTrue(inventoryOne.availability("Peach"));
        assertFalse(inventoryOne.availability("Paper Towel - 6 Packs"));
    }


    @Test
    public void inputDataTest1() {
        gateway.inputDatabase(inventoryTwo);
        assertTrue(inventoryTwo.availability("Peach"));
        assertTrue(inventoryTwo.availability("Paper Towel - 6 Packs"));
        assertTrue(inventoryTwo.availability("Canon EOS Camera"));
    }

    @Test
    public void inputDataTest2() {
        gateway.inputDatabase(inventoryTwo);
        assertFalse(inventoryTwo.availability("random"));
    }




}