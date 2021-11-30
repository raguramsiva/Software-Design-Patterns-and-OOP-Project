package uses;

public class SilverMember extends Membership {

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
    public SilverMember(String memberNumber, String validDate, String expireDate,
                        String mobil, String paymentMethod, String address) {
        super(memberNumber, validDate, expireDate, mobil, paymentMethod, address);
        super.setMemberType("Silver Membership");
    }

    /** The discount rate for the silver membership.
     *
     * @return The discount rate.
     */
    @Override
    public double MemberDiscount() {
        return 1;
    }

}
