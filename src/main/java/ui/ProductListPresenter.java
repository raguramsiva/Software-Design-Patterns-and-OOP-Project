package ui;

import database.DatabaseAccessBoundary;
import uses.InventorySystem;

import java.io.File;
import java.util.ArrayList;

public class ProductListPresenter {

    private final DatabaseAccessBoundary gateway;
    private final InventorySystem inventory;

    public ProductListPresenter(DatabaseAccessBoundary gateway) {
        this.gateway = gateway;
        this.inventory = new InventorySystem();
    }

    public ArrayList<ArrayList<Object>> createProductList(File filename){
       this.gateway.inputData(filename, this.inventory);
        return this.inventory.productStringList();
    }








}
