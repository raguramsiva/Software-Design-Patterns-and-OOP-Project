package controllers;

import uses.InventorySystemBoundary;
import uses.UserManagerBoundary;

public interface ServiceInjector {

    /** A method to inject an InventorySystem
     * @return An InventorySystem
     */
    InventorySystemBoundary injectInventory();

    /** A method to inject a UserManager
     * @return A UserManager
     */
    UserManagerBoundary injectUserManager();
}
