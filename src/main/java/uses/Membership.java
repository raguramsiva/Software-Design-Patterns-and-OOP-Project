package uses;

import users.Customer;

public abstract class Membership {

    private final String memberNumber;
    private final String validDate;
    private final String expireDate;
    private String mobile;
    private String paymentMethod;
    private String address;
    private String mobileType;

    /** An initializer for Users.Membership.
     * @param memberNumber A member's memberNumber
     * @param validDate A member's membership validDate
     * @param expireDate A member's membership expireDate
     * @param mobile A member's mobil
     * @param paymentMethod A member's paymentMethod
     * @param address A member's address
     */
    public Membership(String memberNumber, String validDate, String expireDate,
                      String mobile, String paymentMethod, String address){
        this.memberNumber = memberNumber;
        this.validDate = validDate;
        this.expireDate = expireDate;
        this.mobile = mobile;
        this.paymentMethod = paymentMethod;
        this.address = address;

    }

    /** Makes a modification for a member's mobile phone number
     * @param newMobil a new mobile phone number
     */
    public void modifyMobile(String newMobil){
        this.mobile = newMobil;
    }

    /** Makes a modification for a member's payment method
     * @param newPayment a newPayment
     */
    public void modifyPayment(String newPayment){
        this.paymentMethod = newPayment;
    }

    /** Makes a modification for a member's address
     * @param newAddress a new address
     */
    public void modifyAddress(String newAddress){
        this.address = newAddress;
    }

    /** Getter method for member's memberNumber.
     * @return member's memberNumber
     */
    public String getMemberNum(){
        return this.memberNumber;
    }

    /** Getter method for member's membership validDate.
     * @return member's membership validDate
     */
    public String getValidDate(){
        return this.validDate;
    }

    /** Getter method for member's membership expireDate.
     * @return member's membership expireDate
     */
    public String getExpireDate(){
        return this.expireDate;
    }

    /** Getter method for member's mobile number.
     * @return member's mobile number
     */
    public String getMobile(){
        return this.mobile;
    }

    /** Getter method for member's paymentMethod.
     * @return member's paymentMethod
     */
    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    /** Getter method for member's address.
     * @return member's address
     */
    public String getAddress() {
        return this.address;
    }

    /** If a member has product in the shopping cart, a 0.05 discount will apply to him/her.
     * @return the discount rate
     */

    public double discount(Customer c){
        if (c.cartTotal() != 0){
            return 0.05;
        }
        return 0;
    }

    public abstract double MemberDiscount();

    public void setMobileType(String type){
        this.mobileType = type;
    }

    public String MemberState() {
        return this.mobileType;
    }







}




