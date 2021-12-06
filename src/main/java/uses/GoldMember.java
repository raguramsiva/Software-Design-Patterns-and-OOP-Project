package uses;

public class GoldMember extends Membership {
    /**
     * An initializer for Users.Membership.
     *
     * @param memberNumber  A member's memberNumber
     * @param validDate     A member's membership validDate
     * @param expireDate    A member's membership expireDate
     * @param mobil         A member's mobil
     * @param paymentMethod A member's paymentMethod
     * @param address       A member's address
     */
    public GoldMember(String memberNumber, String validDate, String expireDate,
                      String mobil, String paymentMethod, String address) {
        super(memberNumber, validDate, expireDate, mobil, paymentMethod, address);
        super.setMobileType("Gold Membership");
    }


    /** The discount rate for the golden membership - 5 percent discount.
     *
     * @return The discount rate.
     */
    @Override
    public double MemberDiscount(){
        return 0.95;
    }

}
