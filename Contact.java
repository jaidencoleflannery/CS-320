package contacts;

public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        validateId(contactId);
        validateName(firstName, "firstName");
        validateName(lastName, "lastName");
        validatePhone(phoneNumber);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "firstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "lastName");
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private static void validateId(String id) {
        if (isBlank(id) || id.length() > 10) {
            throw new IllegalArgumentException("contactId is invalid.");
        }
    }

    private static void validateName(String value, String field) {
        if (isBlank(value) || value.length() > 10) {
            throw new IllegalArgumentException(field + " is invalid.");
        }
    }

    private static void validateAddress(String address) {
        if (isBlank(address) || address.length() > 30) {
            throw new IllegalArgumentException("address is invalid.");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("phoneNumber is invalid.");
        }
    }

}
