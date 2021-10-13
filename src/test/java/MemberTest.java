import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {


    Member MemberA = new Member("1234", "2021.01.01", "2022.01.01",
            "647-123-4567", "Master Card", "123 King St.");



    @Test
    void modifyMobil() {
        MemberA.ModifyMobil("416-123-4567");
        assertEquals("416-123-4567", MemberA.getMobil());

    }

    @Test
    void modifyPayment() {
        MemberA.ModifyPayment("Credit");
        assertEquals("Credit", MemberA.getPaymentMethod());
    }

    @Test
    void modifyAddress() {
        MemberA.ModifyAddress("789 King St.");
        assertEquals("789 King St.", MemberA.getAddress());
    }





}