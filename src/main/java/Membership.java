public class Membership {

    private final String memberNumber;
    private final String validDate;
    private final String expireDate;
    private String Mobil;
    private String paymentMethod;
    private String address;


    public Membership(String number, String validDate, String expireDate,
                      String mobil, String paymentMethod, String address){
        this.memberNumber = number;
        this.validDate = validDate;
        this.expireDate = expireDate;
        this.Mobil = mobil;
        this.paymentMethod = paymentMethod;
        this.address = address;

    }

    public void modifyMobile(String newMobil){
        this.Mobil = newMobil;
    }

    public void modifyPayment(String newPayment){
        this.paymentMethod = newPayment;
    }

    public void modifyAddress(String newAddress){
        this.address = newAddress;
    }

    public String getMemberNum(){
        return this.memberNumber;
    }

    public String getValidDate(){
        return this.validDate;
    }

    public String getExpireDate(){
        return this.expireDate;
    }

    public String getMobile(){
        return this.Mobil;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public String getAddress() {
        return this.address;
    }

    public double discount(Customer c){
        if (!c.shoppingCart.isEmpty()){
            return 0.05;
        }
        return 0;
    }



}




