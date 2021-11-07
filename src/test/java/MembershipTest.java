import Users.Membership;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {


    Membership MembershipA = new Membership("1234", "2021.01.01", "2022.01.01",
            "647-123-4567", "Master Card", "123 King St.");



    @Test
    void modifyMobil() {
        MembershipA.modifyMobile("416-123-4567");
        assertEquals("416-123-4567", MembershipA.getMobile());

    }

    @Test
    void modifyPayment() {
        MembershipA.modifyPayment("Credit");
        assertEquals("Credit", MembershipA.getPaymentMethod());
    }

    @Test
    void modifyAddress() {
        MembershipA.modifyAddress("789 King St.");
        assertEquals("789 King St.", MembershipA.getAddress());
    }





}