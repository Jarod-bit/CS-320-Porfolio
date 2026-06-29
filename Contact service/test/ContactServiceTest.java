import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C10001", "Rowan", "Price", "6155551284", "44 Aspen Drive");

        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("C10001"));
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();

        Contact firstContact = new Contact("C20002", "Mila", "Grant", "9315558042", "17 Lake Road");
        Contact duplicateContact = new Contact("C20002", "Owen", "Sharp", "8655553390", "88 Hill Street");

        assertTrue(service.addContact(firstContact));
        assertFalse(service.addContact(duplicateContact));
    }

    @Test
    public void testAddNullContact() {
        ContactService service = new ContactService();

        assertFalse(service.addContact(null));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C30003", "Elena", "Wells", "4235556719", "29 Grove Lane");

        service.addContact(contact);

        assertTrue(service.deleteContact("C30003"));
        assertNull(service.getContact("C30003"));
    }

    @Test
    public void testDeleteContactNotFound() {
        ContactService service = new ContactService();

        assertFalse(service.deleteContact("C99999"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C40004", "Lucas", "Bennett", "6295559021", "10 Pearl Court");

        service.addContact(contact);

        assertTrue(service.updateFirstName("C40004", "Miles"));
        assertEquals("Miles", service.getContact("C40004").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C50005", "Ivy", "Foster", "7315554830", "63 Oak Circle");

        service.addContact(contact);

        assertTrue(service.updateLastName("C50005", "Hayes"));
        assertEquals("Hayes", service.getContact("C50005").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C60006", "Theo", "Parker", "2705557104", "5 Sunset Way");

        service.addContact(contact);

        assertTrue(service.updatePhone("C60006", "6155557788"));
        assertEquals("6155557788", service.getContact("C60006").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C70007", "Avery", "Cole", "9015552386", "91 Forest Trail");

        service.addContact(contact);

        assertTrue(service.updateAddress("C70007", "12 Meadow Lane"));
        assertEquals("12 Meadow Lane", service.getContact("C70007").getAddress());
    }

    @Test
    public void testUpdateContactNotFound() {
        ContactService service = new ContactService();

        assertFalse(service.updateFirstName("C88888", "Riley"));
        assertFalse(service.updateLastName("C88888", "Moore"));
        assertFalse(service.updatePhone("C88888", "6155551111"));
        assertFalse(service.updateAddress("C88888", "1 River Bend"));
    }

    @Test
    public void testUpdateInvalidFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C80008", "Nolan", "King", "6155553904", "33 Poplar Ave");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("C80008", "Christopher");
        });
    }

    @Test
    public void testUpdateInvalidPhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C90009", "Clara", "Dean", "9315557741", "72 Elm Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("C90009", "93155A7741");
        });
    }
}
