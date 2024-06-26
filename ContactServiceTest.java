import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// citations: geeksforgeeks, stackoverflow

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService(3); // Initialize with a capacity of 3 for testing
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Elm St");
        assertTrue(service.addContact(contact));
        assertEquals("John", service.contacts[0].getFirstName());
    }

    @Test
    public void testAddContactArrayFull() {
        service.addContact(new Contact("001", "John", "Doe", "1234567890", "123 Elm St"));
        service.addContact(new Contact("002", "Jane", "Doe", "2345678901", "234 Elm St"));
        service.addContact(new Contact("003", "Jim", "Beam", "3456789012", "345 Elm St"));
        assertFalse(service.addContact(new Contact("004", "Jack", "Daniels", "4567890123", "456 Elm St")));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertTrue(service.deleteContact("001"));
        assertNull(service.contacts[0]);
    }

    @Test
    public void testDeleteNonexistentContact() {
        assertFalse(service.deleteContact("999"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertTrue(service.updateContact("001", "Johnny", null, null, null));
        assertEquals("Johnny", service.contacts[0].getFirstName());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(service.updateContact("999", "Johnny", null, null, null));
    }
}
