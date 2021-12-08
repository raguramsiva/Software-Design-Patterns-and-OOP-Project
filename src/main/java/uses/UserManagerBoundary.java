package uses;

import users.Administrator;
import users.Customer;
import users.User;

public interface UserManagerBoundary {
    /**
     * Creates a customer.
     *
     * @param username Users.Customer's username
     * @param password Users.Customer's password
     * @return Users.Customer
     */

    Customer createCustomer(String username, String password);

    /**
     * Creates an administrator.
     *
     * @param username Users.Administrator's username
     * @param password Users.Administrator's password
     * @return Users.Administrator
     */

    Administrator createAdministrator(String username, String password);

    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    void add(User user);

    /**
     * Return the User associated with username.
     *
     * @param username the username of the user to get.
     */
    User getUser(String username);
}
