package uses;


public class PlatinumMember extends Membership{
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
    public PlatinumMember(String memberNumber, String validDate, String expireDate,
                          String mobil, String paymentMethod, String address) {
        super(memberNumber, validDate, expireDate, mobil, paymentMethod, address);
        super.setMemberType("Platinum Membership");
    }


    /** Discount rate of the platinum membership - 10 percent discount.
     *
     * @return Discount rate
     */
    @Override
    public double MemberDiscount() {
        return 0.9;
    }
}
