package database;

import uses.InventorySystem;

import java.io.*;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
@SuppressWarnings("unchecked")

public class DatabaseInput {


    /**
     * Database.DatabaseInput will read the files from each inventory database
     * and store the data in to the assigned Uses.InventorySystem.
     * @param Inventory The Uses.InventorySystem contain the information of inventories.
     */

    public void inputData(InventorySystem Inventory){

        File path = new File("src/main/java/database/data");

        File [] files = path.listFiles();
        assert files != null;
        for (File f : files){
            inputDatabase(new File(String.valueOf(f)), Inventory);
        }

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
                int stock = quantity.intValue();
                Inventory.setInventory(Inventory.createProduct(name, price, stock));
            }

        } catch (NumberFormatException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }

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






