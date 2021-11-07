package Uses;

import Users.Administrator;
import Users.Customer;
import Users.User;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> accounts;

    public UserManager() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Creates a customer.
     *
     * @param username Users.Customer's username
     * @param password Users.Customer's password
     * @return Users.Customer
     */

    public Customer createCustomer (String username, String password){
        return new Customer(username, password);
    }


        /** Creates an administrator.
         * @param username Users.Administrator's username
         * @param password Users.Administrator's password
         * @return Users.Administrator
         */

        public Administrator createAdministrator (String username, String password){
            return new Administrator(username, password);
        }
}
