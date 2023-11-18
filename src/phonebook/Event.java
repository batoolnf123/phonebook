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
public class Event implements Comparable<Event> {
    String title;
    Date date;
    String time;
    String location;
    boolean EventType;  // event true , appointment = false;
    LinkedList <String> contacts_names;

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.EventType = true;
        this.contacts_names = new LinkedList<String> ();
    }
    
    public Event(String title, String date, String time, String location, boolean t, String contact) {
        this.title = title;
        this.date = new Date(date);
        this.time = time;
        this.location = location;
        this.EventType =t;
        this.contacts_names = new LinkedList<String> ();
        contacts_names.insert(contact);
    }}
