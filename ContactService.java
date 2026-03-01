package contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public Contact add(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        String id = contact.getContactId();
        if (id == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with provided ID already exists.");
        }

        contacts.put(id, contact);
        return contact;
    }

    public void delete(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }
        contacts.remove(contactId);
    }

    public void updateContact(
            String contactId,
            String firstName,
            String lastName,
            String phoneNumber,
            String address
    ) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        Contact c = contacts.get(contactId);
        if (c == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        if (firstName != null) c.setFirstName(firstName);
        if (lastName != null) c.setLastName(lastName);
        if (phoneNumber != null) c.setPhoneNumber(phoneNumber);
        if (address != null) c.setAddress(address);
    }

    public Contact get(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }
        return contacts.get(contactId);
    }
}
