package database;

import uses.InventorySystemBoundary;

import java.io.File;

public interface DatabaseAccessBoundary {

    /**
     * Read multiple data files and input product information
     * into inventory.
     *
     * @param inventory an InventorySystem
     */
    void inputDatabase(InventorySystemBoundary inventory);

    /**
     * Read a data file and input product information
     * into inventory.
     *
     * @param inventory an InventorySystem
     */

    void inputData(File fileName, InventorySystemBoundary inventory);

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
