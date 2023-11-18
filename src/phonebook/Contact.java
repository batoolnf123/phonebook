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
    String name;
    String phonenumber;
    String emailaddress;
    String address;
    Date birthday; 
    String notes;
    LinkedList<Event> events ; 
   
    public Contact() {
        this.name = "";
        this.phonenumber = "";
        this.emailaddress = "";
        this.address = "";
        this.birthday = null;
        this.notes = "";
        events = new LinkedList<Event>();
    }

    public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.emailaddress = emailaddress;
        this.address = address;
        this.birthday = new Date(birthday);
        this.notes = notes;
        events = new LinkedList<Event>();
    }

    @Override
    public String toString() {
        return "\nName: " + name +
                    "\nPhone Number: " + phonenumber +
                    "\nEmail Address: " + emailaddress +
                    "\nAddress: " +  address +
                    "\nBirthday: " + birthday +
                    "\nNotes: " + notes + 
                    "\nEvents : " + events.toString();

    }
