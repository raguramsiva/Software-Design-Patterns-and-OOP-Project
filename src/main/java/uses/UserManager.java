package uses;

import users.Administrator;
import users.Customer;
import users.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserManager implements Serializable{

    private UserManager um;

    private final Map<String, User> users = new HashMap<>();


    /**
     * Creates a customer.
     *
     * @param username Users.Customer's username
     * @param password Users.Customer's password
     * @return Users.Customer
     */

    public Customer createCustomer(String username, String password){
        Customer c = new Customer(username, password);
        users.put(c.getUsername(), c);
        return c;
    }


    /** Creates an administrator.
     * @param username Users.Administrator's username
     * @param password Users.Administrator's password
     * @return Users.Administrator
     */

    public Administrator createAdministrator(String username, String password){
        Administrator a = new Administrator(username, password);
        users.put(a.getUsername(), a);
        return a;
    }


    /**
     * Add user to this user list.
     * @param user the user to add
     */
    public void add(User user) {
        users.put(user.getUsername(), user);
    }


    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public User getUser(String username) {
        return users.get(username);
    }


}
