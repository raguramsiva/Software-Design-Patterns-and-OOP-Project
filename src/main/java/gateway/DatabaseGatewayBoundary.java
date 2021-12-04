package gateway;

import uses.InventorySystem;

import java.io.File;

public interface DatabaseGatewayBoundary {

    /**
     * Read multiple data files and input product information
     * into inventory.
     *
     * @param inventory
     */
    void inputDatabase(InventorySystem inventory);

    /**
     * Read a data file and input product information
     * into inventory.
     *
     * @param inventory
     */

    void inputData(File fileName, InventorySystem inventory);

    /**
     * Writes a product to the data files in database/data if product does
     * not already exist in database. Otherwise, updates the price and stock
     * quantity of an existing product in the inventory.
     *
     * @param name     name of a product
     * @param price    price of a produce
     * @param quantity stock quantity of a product
     */
    void writeDatabase(String name, double price, int quantity);
}
