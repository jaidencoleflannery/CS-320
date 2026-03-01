package contacts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void validContactIsCreated() {
        Contact c = new Contact(
                "12345",
                "John",
                "Doe",
                "1234567890",
                "Home"
        );

        assertEquals("12345", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhoneNumber());
        assertEquals("Home", c.getAddress());
    }

    // Contact ID tests

    @Test
    void contactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "Home")
        );
    }

    @Test
    void contactIdCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "Home")
        );
    }

    @Test
    void contactIdIsNotUpdatable() {
        Contact c = new Contact(
                "12345",
                "John",
                "Doe",
                "1234567890",
                "Home"
        );

        assertEquals("12345", c.getContactId());
    }

    // First name tests

    @Test
    void firstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", null, "Doe", "1234567890", "Home")
        );
    }

    @Test
    void firstNameCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "VeryLongName", "Doe", "1234567890", "Home")
        );
    }

    // Last name tests

    @Test
    void lastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", null, "1234567890", "Home")
        );
    }

    @Test
    void lastNameCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "VeryLongName", "1234567890", "Home")
        );
    }

    // Phone tests

    @Test
    void phoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", null, "Home")
        );
    }

    @Test
    void phoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "12345", "Home")
        );
    }

    // Address tests

    @Test
    void addressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "1234567890", null)
        );
    }

    @Test
    void addressCannotExceedThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "123",
                        "John",
                        "Doe",
                        "1234567890",
                        "This address is definitely longer than thirty characters and stuff or whatever."
                )
        );
    }
}
