package Database;

import Uses.InventorySystem;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DatabaseInput {


    /**
     * Database.DatabaseInput will read the files from each inventory database
     * and store the data in to the assigned Uses.InventorySystem.
     * @param Inventory The Uses.InventorySystem contain the information of inventories.
     */

    public void inputData(InventorySystem Inventory){
        inputDatabase(new File("src/main/java/Database/Household_Supplies_Data.json"), Inventory);
        inputDatabase(new File("src/main/java/Database/Meat_Data.json"), Inventory);
        inputDatabase(new File("src/main/java/Database/Fruits_and_Vegetables.json"), Inventory);
    }

    /** A method help to store data from database.
     * @param FileName The file's path name.
     * @param Inventory The Uses.InventorySystem stores the data.
     */

    private void inputDatabase(File FileName, InventorySystem Inventory) {
        try {
            JSONParser parser = new JSONParser();

            JSONArray products = (JSONArray) parser.parse(new FileReader(FileName));

            for (Object p : products)
            {
                JSONObject product = (JSONObject) p;

                String name = (String) product.get("name");
                Double price = (Double) product.get("price");
                Long quantity = (Long) product.get("quantity");
                Integer stock = quantity.intValue();
                Inventory.setInventory(Inventory.createProduct(name, price, stock));
            }

        } catch (NumberFormatException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
