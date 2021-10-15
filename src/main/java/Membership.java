public class Membership {

    private String MemberNumber;
    private String ValidDate;
    private String ExpireDate;
    private String Mobil;
    private String PaymentMethod;
    private String Address;


    public Membership(String number, String validDate, String expireDate,
                      String mobil, String paymentMethod, String address){
        this.MemberNumber = number;
        this.ValidDate = validDate;
        this.ExpireDate = expireDate;
        this.Mobil = mobil;
        this.PaymentMethod = paymentMethod;
        this.Address = address;

    }

    public void ModifyMobil(String newMobil){
        this.Mobil = newMobil;
    }

    public void ModifyPayment(String newPayment){
        this.PaymentMethod = newPayment;
    }

    public void ModifyAddress(String newAddress){
        this.Address = newAddress;
    }

    public String getMemberNum(){
        return this.MemberNumber;
    }

    public String getValidDate(){
        return this.ValidDate;
    }

    public String getExpireDate(){
        return this.ExpireDate;
    }

    public String getMobil(){
        return this.Mobil;
    }

    public String getPaymentMethod(){
        return this.PaymentMethod;
    }

    public String getAddress() {
        return this.Address;
    }

    public double Discount(Customer c){
        if (!c.shoppingCart.isEmpty()){
            return 0.05;
        }
        return 0;
    }



}




