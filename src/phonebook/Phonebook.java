
package phonebook;


public class Phonebook {
 static BST<Contact> AllContacts;
    static BST<Event> AllEvent;

    public PhoneBook() {//joury
        AllContacts = new BST<Contact>();
        AllEvent = new BST<Event>();
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

    public void printAllContactsInOrder() {//joury
        AllContacts.inOrder();
    }

    public void printAllContactsPreOrder() {//joury
        AllContacts.preOrder();
    }

}

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
