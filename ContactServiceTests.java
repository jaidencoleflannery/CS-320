package contacts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
    }

    @Test
    void add_allowsUniqueId() {
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "56542");
        Contact c2 = new Contact("2", "Jane", "Doe", "0987654321", "456 Oak Ave");

        assertDoesNotThrow(() -> service.add(c1));
        assertDoesNotThrow(() -> service.add(c2));

        assertSame(c1, service.get("1"));
        assertSame(c2, service.get("2"));
    }

    @Test
    void delete_removesByContactId() {
        Contact c1 = new Contact("1", "Jaiden", "Flannery", "1234567890", "100 Arch St");
        service.add(c1);

        assertDoesNotThrow(() -> service.delete("1"));
        assertNull(service.get("1"));
    }

    @Test
    void update_updatesUpdatableFieldsByContactId() {
        Contact c1 = new Contact("1", "Mike", "Samson", "1234567890", "123 South Dakota");
        service.add(c1);

        service.updateContact("1", "NewFirst", "NewLast", "1112223333", "999 New Rd");

        Contact updated = service.get("1");
        assertNotNull(updated);
        assertEquals("NewFirst", updated.getFirstName());
        assertEquals("NewLast", updated.getLastName());
        assertEquals("1112223333", updated.getPhoneNumber());
        assertEquals("999 New Rd", updated.getAddress());
    }
}
