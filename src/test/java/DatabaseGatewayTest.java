import gateway.DatabaseGateway;
import uses.InventorySystem;
import org.junit.Test;


import javax.xml.crypto.Data;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseGatewayTest {

    DatabaseGateway gateway = new DatabaseGateway();
    InventorySystem inventoryOne = new InventorySystem();
    InventorySystem inventoryTwo = new InventorySystem();


    @Test
    public void inputDatabaseTest() {
        gateway.inputDatabase(new File("src/main/java/database/Fruits_and_Vegetables.json"), inventoryOne);
        assertTrue(inventoryOne.availability("Peaches"));
        assertFalse(inventoryOne.availability("Paper Towel - 6 Packs"));
    }


    @Test
    public void inputDataTest() {
        gateway.inputData(inventoryTwo);
        assertTrue(inventoryTwo.availability("Peaches"));
        assertTrue(inventoryTwo.availability("Paper Towel - 6 Packs"));
        assertTrue(inventoryTwo.availability("Canon EOS Camera"));
    }




}