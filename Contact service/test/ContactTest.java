import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("C48291", "Mason", "Reed", "9315552481", "82 Cedar Lane");

        assertEquals("C48291", contact.getContactId());
        assertEquals("Mason", contact.getFirstName());
        assertEquals("Reed", contact.getLastName());
        assertEquals("9315552481", contact.getPhone());
        assertEquals("82 Cedar Lane", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CONTACT48291", "Mason", "Reed", "9315552481", "82 Cedar Lane");
        });
    }

    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Mason", "Reed", "9315552481", "82 Cedar Lane");
        });
    }

    @Test
    public void testFirstNameTooLong() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("C15824", "Maximillian", "Stone", "6155559042", "14 Maple Court");
    });
}

    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C15824", null, "Stone", "6155559042", "14 Maple Court");
        });
    }

    @Test
    public void testLastNameTooLong() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("C73910", "Nora", "Williamsons", "2705551639", "700 River Road");
    });
}

    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C73910", "Nora", null, "2705551639", "700 River Road");
        });
    }

    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C60428", "Caleb", "Brooks", "865555193", "9 Pine Street");
        });
    }

    @Test
    public void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C60428", "Caleb", "Brooks", "86555519384", "9 Pine Street");
        });
    }

    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C60428", "Caleb", "Brooks", null, "9 Pine Street");
        });
    }

    @Test
    public void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C60428", "Caleb", "Brooks", "86555A1938", "9 Pine Street");
        });
    }

    @Test
    public void testAddressTooLong() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("C91573", "Tessa", "Miles", "4235557712", "12345 Long Mountain View Drive Apt");
    });
}

    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C91573", "Tessa", "Miles", "4235557712", null);
        });
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("C28641", "Evan", "Clark", "7315556204", "55 Birch Ave");

        contact.setFirstName("Lena");
        contact.setLastName("Hale");
        contact.setPhone("6295554487");
        contact.setAddress("21 Willow Way");

        assertEquals("Lena", contact.getFirstName());
        assertEquals("Hale", contact.getLastName());
        assertEquals("6295554487", contact.getPhone());
        assertEquals("21 Willow Way", contact.getAddress());
    }
}