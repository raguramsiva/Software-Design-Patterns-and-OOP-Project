package transactions;

import gateway.DatabaseGatewayBoundary;
import users.Customer;
import uses.ApplyMembership;
import uses.InventorySystem;
import uses.UserManager;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransaction implements TransactionFactory{

    /**
     * A method for a customer transaction.
     *
     * @param responses A list of a customer's inputs.
     * @return A list of strings representing a customer's transaction messages.
     */
    @Override
    public ArrayList<String> createTransaction(DatabaseGatewayBoundary gw, InventorySystem is, UserManager um, List<String> responses) {
        try {
            ArrayList<String> output = new ArrayList<>();
            Customer c = um.createCustomer(responses.get(0), responses.get(1));
            if (checkInvalidInput(responses, 7)) {
                output.add("Invalid membership input, please try again latter.");
                return output;
            }
            ApplyMembership apply = new ApplyMembership();
            apply.NewMembership(c, responses.get(4), responses.get(5), responses.get(6), responses.get(7));
            String cartAction = is.addToCart(c, responses.get(2), Integer.parseInt(responses.get(3)));


            String cartMember = is.addToCart(c, responses.get(7), 1);
            String total = is.customerTotal(c);

            if (is.findProduct(responses.get(2)) != null) {
                if (is.findProduct(responses.get(2)).getStock() >= 0) {
                    String name = responses.get(2);
                    double price = is.findProduct(responses.get(2)).getPrice();
                    int stock = is.findProduct(responses.get(2)).getStock();
                    gw.writeDatabase(name, price, stock);
                }
            }

            output.add("");
            output.add("Transaction Summary:");
            output.add(cartAction);
            output.add(cartMember);
            output.add(total);
            return output;
        } catch (IndexOutOfBoundsException ignored) {
        }

        return null;
    }


    /**
     * A method for input member type is valid.
     *
     * @param responses A list of an administrator's inputs.
     * @param IndexOfMember The index of the responses for the MemberShip
     * @return A boolean represent the validation of the input.
     */
    public boolean checkInvalidInput(List<String> responses, int IndexOfMember) {
        return !responses.get(IndexOfMember).equals("Silver Membership") &&
                !responses.get(IndexOfMember).equals("Gold Membership") &&
                !responses.get(IndexOfMember).equals("Platinum Membership");
    }

}
