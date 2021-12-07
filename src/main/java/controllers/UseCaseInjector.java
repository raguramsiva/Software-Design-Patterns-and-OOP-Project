package controllers;

import uses.InventorySystem;
import uses.InventorySystemBoundary;

public class UseCaseInjector implements ServiceInjector {

    @Override
    public InventorySystemBoundary injectInventory() {
        return new InventorySystem();
    }
}
