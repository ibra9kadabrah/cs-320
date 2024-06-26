import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// citations: geeksforgeeks, stackoverflow

public class ContactTest {

    @Test
    public void testContactConstructionValid() {
        // Test with valid inputs
        assertDoesNotThrow(() -> new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactIdTooLong() {
        // Test with an invalid contact ID (more than 10 characters)
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
        assertTrue(e.getMessage().contains("invalid contact id"));
    }

    @Test
    public void testFirstNameTooLong() {
        // Test with an invalid first name (more than 10 characters)
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "JohnathanSmith", "Doe", "1234567890", "123 Main St"));
        assertTrue(e.getMessage().contains("invalid first name"));
    }

    @Test
    public void testLastNameTooLong() {
        // Test with an invalid last name (more than 10 characters)
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "DoeSmithsonian", "1234567890", "123 Main St"));
        assertTrue(e.getMessage().contains("wrong last name"));
    }

    @Test
    public void testPhoneInvalid() {
        // Test with an invalid phone number (not exactly 10 digits or non-numeric)
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "123456789", "123 Main St"));
        assertTrue(e.getMessage().contains("wrong phone number"));
    }

    @Test
    public void testAddressTooLong() {
        // Test with an invalid address (more than 30 characters)
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street Blah Blah Blah Blah"));
        assertTrue(e.getMessage().contains("wrong address"));
    }
}
