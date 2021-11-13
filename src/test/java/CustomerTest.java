import Entities.Product;
import Users.Customer;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {


    @Test
    public void cartTotalTest() {
        Product item = new Product("apple",0.50,5000);
        Customer c = new Customer("Name", "password1234");
        c.add(item,10);
        assertEquals(5.00, c.cartTotal());

    }




}