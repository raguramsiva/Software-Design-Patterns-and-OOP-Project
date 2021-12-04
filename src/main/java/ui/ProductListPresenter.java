package ui;

import gateway.DatabaseGatewayBoundary;
import uses.InventorySystem;

import java.io.File;
import java.util.ArrayList;

public class ProductListPresenter {

    private final DatabaseGatewayBoundary gateway;
    private final InventorySystem inventory;

    public ProductListPresenter(DatabaseGatewayBoundary gateway) {
        this.gateway = gateway;
        this.inventory = new InventorySystem();
    }

    public ArrayList<ArrayList<Object>> createProductList(File filename){
       this.gateway.inputData(filename, this.inventory);
        return this.inventory.productStringList();
    }








}
