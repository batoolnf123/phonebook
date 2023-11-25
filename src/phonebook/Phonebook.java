
package phonebook;


public class Phonebook {
    static BST<Contact> AllContacts;
    static linkedlist<Event> AllEvent;

    public PhoneBook() {//joury
        AllContacts = new BST<Contact>();
        AllEvent = new linkedlist<Event>();
    }
    public void addContact(Contact newContact) {//joury
        boolean add = false;
        if (AllContacts.checkPhoneExist(newContact.phoneNumber)) {//check by phone number
            System.out.println("this Contact phone is already exist");
            return;
        } else { //the phone number is not exist
            add = AllContacts.insert(newContact.contactName, newContact);
            if (!add) {

                System.out.println("this Contact name is already exist");
                return;
            } else {
                System.out.println("the contact added sucsessfuly");
            }

        }

    }

    public Contact searchByName(String name) {//anoud

        if (AllContacts.empty()) {
            return null;
        }

        boolean cFound = AllContacts.findkey(name);
        if (cFound) {
            return AllContacts.retrieve();
        }
        return null;

    }

    public void printAllContactsInOrder() {//joury
        AllContacts.inOrder();
    }

    public void printAllContactsPreOrder() {//joury
        AllContacts.preOrder();
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
}
