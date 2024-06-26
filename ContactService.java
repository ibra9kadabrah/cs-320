public class ContactService {
    private Contact[] contacts; // create an array of type Contact from Contact.java
    private int size; // count number of contacts

    public ContactService(int n) {
        contacts = new Contact[n];
        size = 0;
    }
    
    public boolean addContact(Contact contact) { // simple boolean function to check if operation is true of fales
        if (size >= contacts.length) {
            System.out.println("array of contacts is full");
            return false;
        }
        contacts[size++] = contact; // size++ increases after statement is done so contacts[0] is filled then size increments by 1
        return true;
    }

    public boolean deleteContact(String contactId) {
        for (int i = 0; i < size; i++) {
            if (contacts[i].getContactId().equals(contactId)) {
                System.arraycopy(contacts, i + 1; contacts, i, size -i - 1);
                contacts[--size] == null;
                return true;
            }
        }
        return false;
    }

    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        for (int i = 0; i < size; i++) {
            if (contacts[i].getContactId().equals(contactId)) {
                if (firstName != null && !firstName.isEmpty()) contacts[i].setFirstName(firstName);
                if (lastName != null && !lastName.isEmpty()) contacts[i].setLastName(lastName);
                if (phone != null && !phone.isEmpty()) contacts[i].setPhone(phone);
                if (address != null && !address.isEmpty()) contacts[i].setAddress(address);
                return true;
            }
        }
        return false;
    }
}