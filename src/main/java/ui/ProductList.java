package ui;

import database.DatabaseAccessBoundary;
import uses.InventorySystemBoundary;

import java.io.File;
import java.util.ArrayList;

public class ProductList {

    private final DatabaseAccessBoundary access;
    private final InventorySystemBoundary inventory;

    /** A constructor for ProductList
     * @param access DatabaseAccessBoundary
     */
    public ProductList(DatabaseAccessBoundary access, InventorySystemBoundary inventory) {
        this.access = access;
        this.inventory = inventory;
    }

    /** A method that creates a list of products from the data directory
     * @param filename a file path
     * @return a list of products
     */
    public ArrayList<ArrayList<Object>> createProductList(File filename){
       this.access.inputData(filename, this.inventory);
        return this.inventory.productStringList();
    }








}
