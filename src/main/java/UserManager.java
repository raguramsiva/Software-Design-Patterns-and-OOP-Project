import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> accounts;

    public UserManager() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Creates a customer.
     *
     * @param username Customer's username
     * @param password Customer's password
     * @return Customer
     */

    public Customer createCustomer (String username, String password){
        return new Customer(username, password);
    }


        /** Creates an administrator.
         * @param username Administrator's username
         * @param password Administrator's password
         * @return Administrator
         */

        public Administrator createAdministrator (String username, String password){
            return new Administrator(username, password);
        }
}
