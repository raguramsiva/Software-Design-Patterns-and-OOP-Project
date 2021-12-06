package ui;

import database.DatabaseAccessBoundary;
import uses.InventorySystem;

import java.io.File;
import java.util.ArrayList;

public class ProductListPresenter {

    private final DatabaseAccessBoundary access;
    private final InventorySystem inventory;

    public ProductListPresenter(DatabaseAccessBoundary access) {
        this.access = access;
        this.inventory = new InventorySystem();
    }

    public ArrayList<ArrayList<Object>> createProductList(File filename){
       this.access.inputData(filename, this.inventory);
        return this.inventory.productStringList();
    }








}
