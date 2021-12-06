package uses;

import users.Customer;

public class ApplyMembership {
    static int number = 0;


    /**
     * A method to assign the membership to customer.
     *
     * @param customer The customer need to assign the membership
     * @param mobile The customer's contact number.
     * @param payment The payment method
     * @param address The shipping address
     * @param memberType The type of the membership
     *
     */
    public void newMembership(Customer customer, String mobile, String payment,
                              String address, String memberType){
        number += 1;
        String MemberNumber = String.valueOf(number);
        Membership member = null;
        if (memberType.equalsIgnoreCase("Gold Membership")){
            member = new GoldMember(MemberNumber,String.valueOf(java.time.LocalDate.now()),
                    String.valueOf(java.time.LocalDate.now().plusYears(1)), mobile, payment, address);

        } else if (memberType.equalsIgnoreCase("Silver Membership")){
            member = new SilverMember(MemberNumber,String.valueOf(java.time.LocalDate.now()),
                    String.valueOf(java.time.LocalDate.now().plusYears(1)), mobile, payment, address);

        } else if (memberType.equalsIgnoreCase("Platinum Membership")){
            member = new PlatinumMember(MemberNumber,String.valueOf(java.time.LocalDate.now()),
                    String.valueOf(java.time.LocalDate.now().plusYears(1)), mobile, payment, address);

        }


        customer.applyMembership(member);


    }




}