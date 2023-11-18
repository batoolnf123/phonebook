/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonebook;
import java.util.Date;
/**
 *
 * @author batoolalfouzan
 */
public class Contact implements Comparable<Contact> {
//joury
    public String contactsName;
    public String phoneNumber;
    public String emailAddress;
    public String Address;
    public String birthday;
    public String notes;

    public Contact() {//joury
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

    }
    
    public String toString() {//joury
        return "Contact{" + "contactsName is" + contactsName + ", phoneNumber is" + phoneNumber + ", email Address is" + emailAddress + ", Address is" + Address + ", birthday is" + birthday + ", notes is" + notes + '}';
    }
     
}

     
}

