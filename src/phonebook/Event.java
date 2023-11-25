/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonebook;

/**
 *
 * @author batoolalfouzan
 */
public class Event implements Comparable<Event> {

    private String title;
    private String date;
    private String time;
    private String location;

    linkedlist<Contact> contactsinEvent; 

    Contact involvedContact;
    String contactName;

    public Event() {
        this.title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.contactName = "";
        involvedContact = new Contact();
        contactsinEvent = new linkedlist<Contact>();

    }

    public Event(String title, String date, String time, String location) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        involvedContact = new Contact();
        contactsinEvent = new linkedlist<Contact>();

    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setInvolvedContact(Contact involvedContact) {
        this.involvedContact = involvedContact;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getContactName() {
        return contactName;
    }

    @Override
    public int CompareTo(Event c) 
    {
        if (getTitle().compareTo(c.getTitle()) == 0) {
            return 0;
        } else if (getTitle().compareTo(c.getTitle()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public void display() { 
        System.out.println("Event title:" + title);
        System.out.println("Contact name:" + contactName);
        System.out.println("Event date and time (MM/DD/YYYY HH:MM):" + date + time);
        System.out.println("Event location:" + location);
    }

}

