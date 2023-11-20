
package phonebook;
import java.util.Date;

public class Contact implements Comparable<Contact> {
//joury
    public String contactsName;
    public String phoneNumber;
    public String emailAddress;
    public String Address;
    public String birthday;
    public String notes;
    public LinkedList<Event> Events;

    public Contact() {//joury
        Events=new LinkedList<Event>();
        contactsName = "";
        phoneNumber = "";
        emailAddress = "";
        Address = "";
        birthday = "";
        notes = "";
    }

    public Contact(String contactsName, String phoneNumber, String emailAddress, String Address, String birthday, String notes) {//joury
        this.contactsName = contactsName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.Address = Address;
        this.birthday = birthday;
        this.notes = notes;
        Events=new LinkedList<Event>();

    }

  
    public String toString() {
        return "Contact{" + "contactsName is" + contactsName + ", phoneNumber is" + phoneNumber + ", email Address is" + emailAddress + ", Address is" + Address + ", birthday is" + birthday + ", notes is" + notes + '}';
    }
    /* public int compareTo(Contact o) { //are we going to make comp. interface? 

            return (this.name.compareToIgnoreCase(o.name));
        
    }*/

    public int CompareTo(Contact c) {
        if (contactsName.compareTo(c.contactsName) == 0) {
            return 0;
        } else if (contactsName.compareTo(c.contactsName) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}

