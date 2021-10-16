import org.junit.*;

public class CustomerTest {

    @Test
    public void add() {
        Product item = new Product("apple",0.5,5000);
        Customer person = new Customer("Name", "password1234");
        int desiredQuantity = 2500;
        person.add(item, desiredQuantity);
        assert(person.shoppingCart.containsKey(item));
        assert(person.shoppingCart.containsValue(2500));
    }




}