Public class Contact {
    private final String contactId; // final means its a constant
    private String firstName;
    private String lastName;
    private String phone; // i am storign the number as a string
    private String address;
}

public Contact(String contactId, String firstName, String lastName, String phone, String address) {
    if (contact == null || contactId.length() > 10) { // check if contact id is entered and more than 10 chars
        throw new IllegalArgumentException("wrong contact id")
    
    }
    this.contactId = contactId(contactId); // check contactId is valid then store it  ensuring object is not created with invalid data
    this.firstName = firstName(firstName);
    this.lastName = lastName(lastName);
    this.phone = phonValidation(phone);
    this.address = addressValidation(address);
}

private String contactId(String contactId) {
    if (contactId == null || contactId() > 10) { // check if contact id is not null and less than 10. if it is throw exception, if not return contactId
        throw new IllegalArgumentException("invalid contact id")
    } 
    return contactId;
}

private String firstName(String firstName) {
    if (firstName == null || firstName.length() > 10) {
        throw new IllegalArgumentException("invalid first name");
    }
    return firstName;
}

private String lastName(String lastName) {
    if (lastName == null || lastName.length() > 10) {
        throw new IllegalArgumentException("wrong last name");
    }
    return lastName;
}

private String phoneValidation(String phone) {
    if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) { // i use a regular expression with in order to check the whole number is digits. if .matches returns false i negate it and throw an error. interesting edge case
        throw new IllegalArgumentException("wrong phone number");
    }
    return phone;
}

private String addressValidation(String address) {
    if (address == null || address.length() > 30) {
        throw new IllegalArgumentException("wron address");
    }
    return address;
}
// added a getter func after realising i cant access contactId in ContactService.java
public String getContactId() {
    return contactId;
}