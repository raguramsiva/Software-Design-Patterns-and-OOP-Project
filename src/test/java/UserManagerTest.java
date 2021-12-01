import users.Customer;
import users.Administrator;
import uses.UserManager;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserManagerTest {

    UserManager um = new UserManager();



    @Test
    public void createCustomerTest() {
        Customer c = um.createCustomer("user123", "password123");
        assertEquals(um.getUser("user123"), c);
    }

    @Test
    public void createAdministratorTest() {
        Administrator a = um.createAdministrator("user12331", "password123231");
        assertEquals(um.getUser("user12331"), a);
    }




}