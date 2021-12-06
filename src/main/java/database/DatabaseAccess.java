package database;

import uses.InventorySystem;

import java.io.*;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
@SuppressWarnings("unchecked")

public class DatabaseAccess implements DatabaseAccessBoundary {


    /**
     * Database.DatabaseInput will read multiple files and store
     * the data in to the assigned Uses.InventorySystem.
     * @param inventory The Uses.InventorySystem contain the information of inventories.
     */

    @Override
    public void inputDatabase(InventorySystem inventory){

        File path = new File("src/main/java/database/data");

        File [] files = path.listFiles();
        assert files != null;
        for (File f : files){
            inputData(new File(String.valueOf(f)), inventory);
        }

    }

    /**
     * Database.DatabaseInput will a file and store
     * the data in to the assigned Uses.InventorySystem.
     * @param inventory The Uses.InventorySystem contain the information of inventories.
     */

    @Override
    public void inputData(File fileName, InventorySystem inventory) {
        try {
            JSONParser parser = new JSONParser();

            JSONArray products = (JSONArray) parser.parse(new FileReader(fileName));

            for (Object p : products)
            {
                JSONObject product = (JSONObject) p;

                String name = (String) product.get("name");
                Double price = (Double) product.get("price");
                Long quantity = (Long) product.get("quantity");
                int stock = quantity.intValue();
                inventory.setInventory(inventory.createProduct(name, price, stock));
            }

        } catch (NumberFormatException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a product to the data files in database/data if product does
     * not already exist in database. Otherwise, updates the price and stock
     * quantity of an existing product in the inventory.
     * @param name name of a product
     * @param price price of a produce
     * @param quantity stock quantity of a product
     */
    @Override
    public void writeDatabase(String name, double price, int quantity){


        JSONObject item = new JSONObject();
        item.put("name", name);
        item.put("price", price);
        item.put("quantity", quantity);
        item.put("unit", "1 each");

        boolean check = false;

        try {
            JSONParser parser = new JSONParser();

            File path = new File("src/main/java/database/data");
            File [] files = path.listFiles();

            assert files != null;
            for (File f : files){
                JSONArray products = (JSONArray) parser.parse(new FileReader(f));


                for (Object p : products) {
                    JSONObject product = (JSONObject) p;
                    if (name.equals(product.get("name"))) {
                        check = true;
                        product.put("name", name);
                        product.put("price", price);
                        product.put("quantity", quantity);
                        product.put("unit", "1 each");
                        FileWriter file = new FileWriter(f);
                        file.write(products.toJSONString());
                        file.flush();
                        file.close();
                    }
                }

            }

            if (!check){
                JSONArray newProducts = (JSONArray) parser.parse(new FileReader("src/main/java/database/data/New_Products.json"));
                newProducts.add(item);
                FileWriter newFile = new FileWriter("src/main/java/database/data/New_Products.json");
                newFile.write(newProducts.toJSONString());
                newFile.flush();
                newFile.close();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }



}






