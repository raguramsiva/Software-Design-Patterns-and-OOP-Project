import org.junit.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addToCart1() {
        Product item = new Product("apple",0.5,5000);
        Customer person = new Customer("Name", "password1234");
        int desiredQuantity = 2500;

        assertEquals(true, person.addToCart(item, desiredQuantity));
    }


    @Test
    public void addToCart2() {
        Product item = new Product("banana",0.25,1000);
        Customer person = new Customer("Name", "password1234");
        int desiredQuantity = 2000;

        assertEquals(false, person.addToCart(item, desiredQuantity));
    }



}