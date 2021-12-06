import database.DatabaseAccess;
import org.junit.Test;
import controllers.TransactionSystem;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionSystemTest {

    @Test
    public void initializeTransactionTest(){

        ArrayList<String> responses = new ArrayList<>();

        String username = "uncleBob";
        String password = "solidPrinciples";
        String product = "Cucumber";
        String quantity = "10";
        String mobile = "416-850-8274";
        String payment = "credit";
        String address = "555 Main Street";
        String membership = "Silver Membership";

        responses.add(username);
        responses.add(password);
        responses.add(product);
        responses.add(quantity);
        responses.add(mobile);
        responses.add(payment);
        responses.add(address);
        responses.add(membership);

        DatabaseAccess gw = new DatabaseAccess();
        TransactionSystem ts = new TransactionSystem(gw);

        ArrayList<String> expected = new ArrayList<>();

        expected.add("");
        expected.add("Transaction Summary:");
        expected.add("You have added 10 units of Cucumber priced at $0.75 each.");
        expected.add("You have added 1 units of Silver Membership priced at $50.00 each.");
        expected.add("Your total after membership discount is $57.50.");

        ArrayList<String> actual = ts.initializeTransaction(responses, "Customer");

        assertEquals(expected, actual);

    }




}