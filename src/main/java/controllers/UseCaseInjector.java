package controllers;

import uses.InventorySystem;
import uses.InventorySystemBoundary;
import uses.UserManager;
import uses.UserManagerBoundary;

public class UseCaseInjector implements ServiceInjector {

    /** A method to inject an InventorySystem
     * @return An InventorySystem
     */
    @Override
    public InventorySystemBoundary injectInventory() {
        return new InventorySystem();
    }


    /** A method to inject a UserManager
     * @return A UserManager
     */
    @Override
    public UserManagerBoundary injectUserManager() {
        return new UserManager();
    }


}
