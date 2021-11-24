package uses;

import users.Administrator;
import users.Customer;
import users.User;

import java.util.ArrayList;

public class UserManager {

    private UserManager um;

    private UserFileReaderWriter uf = new UserFileReaderWriter();
    private IUserSystemPresenter up;

    private final ArrayList<User> accounts;

    public UserManager() {
        this.accounts = new ArrayList<>();
    }

    public ArrayList<User> getAccounts() {
        return accounts;
    }

    /**
     * Creates a customer.
     *
     * @param username Users.Customer's username
     * @param password Users.Customer's password
     * @return Users.Customer
     */

    public Customer createCustomer (String username, String password){
        Customer c = new Customer(username, password);
        accounts.add(c);
        return c;
    }


    /** Creates an administrator.
     * @param username Users.Administrator's username
     * @param password Users.Administrator's password
     * @return Users.Administrator
     */

    public Administrator createAdministrator (String username, String password){
        Administrator a = new Administrator(username, password);
        accounts.add(a);
        return a;
    }

    public void register(String username, String password){
        Customer c.register(username,password);

    }

    public void exit() {
        uf.saveUserToFile(UserManager.userlist);

    }


}
