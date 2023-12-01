
package phonebook;


public class Phonebook {
  
   public static Scanner input = new Scanner(System.in);

    public static BST<Contact> AllContacts;
    public static linkedlist<Event> events;

    public Phonebook() {//joury
        AllContacts = new BST<Contact>();
        events = new linkedlist<Event>();
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
    
    
    
    public static void deleteEvent(String tit, String n){ 
         
         System.out.println("deleting event" + tit + " with contact"+ n);
         linkedlist <Contact> contactsWithCurrentEvent = getContactsInEvent(tit);
         contactsWithCurrentEvent.findfirst();
         while(!contactsWithCurrentEvent.isEmpty() && !contactsWithCurrentEvent.last()){
             if(contactsWithCurrentEvent.retrieve().getContactName().equals(n))
                 contactsWithCurrentEvent.remove();
             break;
         }
         contactsWithCurrentEvent.findnext();
         if(!contactsWithCurrentEvent.isEmpty() && contactsWithCurrentEvent.retrieve().getContactName().equals(n))
                 contactsWithCurrentEvent.remove();
         if(!contactsWithCurrentEvent.isEmpty())
             return;
         if(events.isEmpty())
             return;
         events.findfirst();
         while(!events.last()){
             if(events.retrieve().getTitle().equals(tit)){
                 events.remove();
                 System.out.println(tit +" event deleted");}
             events.findnext();
              if(events.retrieve().getTitle().equals(tit)){
                 events.remove();
                 System.out.println(tit +" event deleted");}
                 else
                 System.out.println("event can't be deleted because it doesn't exist");
             }
                 
         }

     
         
     public static void DeleteAllEventsWithContact(String n, linkedlist<Event>L){
         while(!L.isEmpty()){
             String currentEventTitle = L.retrieve().getTitle();
             deleteEvent(currentEventTitle,n);
             L.remove();
         }
     }
     
    public static void DeleteContact(String n){
    
        if (AllContacts.empty()) {
            System.out.println("Can't delete because the contact is not found ");
            return;
        }

        linkedlist <Event> L = new linkedlist<>();
        boolean found=AllContacts.findkey(n);
        
            if (!found) {

               
                System.out.println(" Can't delete because the contact is not found");
                return;
            }
            L=AllContacts.retrieve().contactEvents;
            DeleteAllEventsWithContact(n , L);
            boolean deleted =AllContacts.removekey(n);
            if(deleted)
            System.out.println(n+" contact deleted");
            else 
             System.out.println(  "contact not deleted" );
            
        }
    public static linkedlist<Contact> getContactsInEvent(String n){
        Event ThisEvent=searchEventByTitle(n);
        if(ThisEvent!=null)
            return ThisEvent.contactsinEvent;
        return new linkedlist<Contact>();
    }

    public static Event searchEventByTitle(String n) {
        if (events.isEmpty()) {
            return null;
        }

        events.findfirst();
        while (!events.last()) {
            if (events.retrieve().getTitle().equals(n)) {
                return events.retrieve();
            }

            events.findnext();
        }

        if (events.retrieve().getTitle().equals(n)) {
            return events.retrieve();
        } else {
            return null;
        }

    }
    
    
    
    
    
    

    public static Contact searchByName(String name) {//anoud

        if (AllContacts.empty()) {
            return null;
        }

        boolean cFound = AllContacts.findkey(name);
        if (cFound) {
            return AllContacts.retrieve();
        }
        return null;

    }

    public static void PrintAllEvents() {//anoud
        if (!events.isEmpty()) {
            events.findfirst();
            while (!events.last()) {

                System.out.println(events.retrieve().getTitle());
                events.findnext();
            }
            System.out.println(events.retrieve().getTitle());

        } else {
            System.out.println("There are no events to print");
        }
    }

    public void printAllContactsInOrder() {//joury
        AllContacts.inOrder();
    }

    public void printAllContactsPreOrder() {//joury
        AllContacts.preOrder();
    }

    public static void scheduleEvent(Event e, String name) {
        Contact c = searchByName(name);
        if (c == null) {
            System.out.println("Can't schedule, because this contact doesn't exist ");
            return;
        }

        if (!e.isEvent) { //is appointment

            if (!e.contactsinEvent.isEmpty()) {
                System.out.println("this appointment was scheduled before");
                return;
            }
        }

        boolean hasConflict = isConflict(e, c);

        if (!hasConflict) {
            c.contactEvents.addSortedEvent(e); //add the event in the contact's list

            e.contactsinEvent.addSortedContact(c); //add the contact in the event's list

            e.setInvolvedContact(c);//should we remove?
            e.setContactName(name);

            AddEvent(e);//add in the all events
            System.out.println("Event scheduled successfully!");
        } else {
            System.out.println("Can't schedule, because this contact has a conflict");
        }

    }

    public static boolean isConflict(Event event, Contact contact) {//joury
        linkedlist<Event> contactEvents = contact.contactEvents;
        if (contactEvents.isEmpty()) {
            return false;
        }
        contactEvents.findfirst();
        while (!contactEvents.last()) {
            if ((event.getDate().equals(contactEvents.retrieve().getDate())) || (event.getTime().equals(contactEvents.retrieve().getTime()))) {
                return true;
            }
            contactEvents.findnext();

        }
        return false;
    }

    public static void PrintEventByName(String ContactName) {//joury
        if (events.isEmpty()) {
            System.out.println("There are no events with this contact name");
            return;

        }
        events.findfirst();
        while (!events.last()) {
            if (events.retrieve().getContactName().equals(ContactName)) {
                events.retrieve().display();
            }
            events.findnext();
        }
        if (events.retrieve().getContactName().equals(ContactName)) {
            events.retrieve().display();
        }
        System.out.println("There are no events with this contact name");
    }

    public static void printEventByTitle(String n) {//anoud
        if (events.isEmpty()) {
            System.out.println("Event not found!");
        }

        events.findfirst();
        while (!events.last()) {
            if (events.retrieve().getTitle().equals(n)) {
                System.out.println("Event found!");
                events.retrieve().display();
            }

            events.findnext();
        }

        if (events.retrieve().getTitle().equals(n)) {
            System.out.println("Event found!");
            events.retrieve().display();
        } else {
            System.out.println("Event not found!");
        }

    }
    
    
    
     public void AddContact(Contact c) {
        boolean cFound = AllContacts.findkey(c.contactName);
        if (cFound == true) {
            System.out.println("Contact couldn't be added");
        } else {
            AllContacts.insert(c.contactName, c);
            System.out.println("Contact added successfully!");
        }
    }
     

    public static void AddEvent(Event e) {
        //Event eFound = searchEventByTitle(e.getTitle());//n
        //if (eFound == null) {//1
        events.addSortedEvent(e);//n
        //}

    }

    public static int ChooseOption() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event/appointment");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static int searchCriteria2() {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static int searchCriteria() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event title");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the BST Phonebook!");
        Phonebook p = new Phonebook();

        int choice;

        do {
            choice = ChooseOption();
            switch (choice) {
                case 1:

                    System.out.print("Enter the contact's name:");
                    String contactName1 = input.nextLine();
                    contactName1 = input.nextLine();
                    System.out.print("Enter the contact's phone number:");
                    String phoneNumber1 = input.nextLine();
                    System.out.print("Enter the contact's email address:");
                    String emailAddress1 = input.nextLine();
                    System.out.print("Enter the contact's address:");
                    String address1 = input.nextLine();
                    System.out.print("Enter the contact's birthday:");
                    String birthday1 = input.nextLine();
                    System.out.print("Enter any notes for the contact:");
                    String notes1 = input.nextLine();
                    Contact c = new Contact(contactName1, phoneNumber1, emailAddress1, address1, birthday1, notes1);
                    p.AddContact(c);//1

                    break;

                case 2:
                    /*int choice2 = searchCriteria2();
                    switch (choice2) {
                        case 1:
                            System.out.print("Enter the contact's name:");
                            String name = input.nextLine();
                            name = input.nextLine();
                            if (contacts.searchByName(name) == null) {
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.searchByName(name)).display();//2
                            }

                            break;
                        case 2:

                            System.out.print("Enter the contact's Phone Number:");
                            String phonNumber = input.nextLine();
                            phonNumber = input.nextLine();
                            linkedlist<Contact> con = contacts.SearchByPhoneNumber(phonNumber);//3
                            if (!con.isEmpty()) {
                                con.findfirst();
                                while (!con.last()) {
                                    con.retrieve().display();
                                    con.findnext();
                                }
                                con.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }

                            break;

                        case 3:
                            System.out.print("Enter the contact's email:");
                            String email1 = input.nextLine();
                            email1 = input.nextLine();
                            linkedlist<Contact> con1 = contacts.SearchByEmail(email1);//1 retrieve?
                            if (!con1.isEmpty()) {
                                con1.findfirst();
                                while (!con1.last()) {
                                    con1.retrieve().display();
                                    con1.findnext();
                                }
                                con1.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }
                            break;
                        case 4:
                            System.out.print("Enter the contact's Address");
                            String address2 = input.nextLine();
                            address2 = input.nextLine();
                            linkedlist<Contact> con3 = contacts.SearchByAddress(address2);//2
                            if (!con3.isEmpty()) {
                                con3.findfirst();
                                while (!con3.last()) {
                                    con3.retrieve().display();
                                    con3.findnext();
                                }
                                con3.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }
                            break;
                        case 5:
                            System.out.print("Enter the contact's Birthday:");
                            String bday = input.nextLine();
                            bday = input.nextLine();
                            linkedlist<Contact> con4 = contacts.SearchByBirthday(bday);//3
                            if (!con4.isEmpty()) {
                                con4.findfirst();
                                while (!con4.last()) {
                                    con4.retrieve().display();
                                    con4.findnext();
                                }
                                con4.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }
                            break;

                    }*/

                    break;

                case 3:
                    System.out.print("Enter contact name:");
                    String deleteName = input.nextLine();
                    deleteName = input.nextLine();

                   // DeleteContact(deleteName); //4batool

                    break;

                case 4:
                    System.out.print("Enter event title:");
                    String title = input.nextLine();
                    title = input.nextLine();
                    System.out.print("Enter contact name:");
                    String name = input.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY:MM):");
                    String date = input.next();
                    String time = input.next();
                    System.out.print("Enter event location:");
                    String location = input.nextLine();
                    location = input.nextLine();

                    Event eventt = new Event(title, date, time, location);

                    scheduleEvent(eventt, name);//5

                    break;

                case 5:
                    int pick = searchCriteria();
                    switch (pick) {
                        case 1:
                            System.out.print("Enter the contact name:");
                            String Cname = input.nextLine();
                            Cname = input.nextLine();
                            PrintEventByName(Cname);//6
                            break;

                        case 2:
                            System.out.print("Enter the event title:");
                            String title1 = input.nextLine();
                            title1 = input.nextLine();
                            printEventByTitle(title1);
                            break;

                    }
                    break;

                case 6:
                    System.out.print("Enter the contact's first name:");
                    String firstname = input.next();

                    linkedlist<Contact> contactList = AllContacts.SearchByFirstName(firstname);

                    if (contactList == null) {
                        break;
                    }
                    contactList.findfirst();
                    while (!contactList.last()) {
                        contactList.retrieve().display();
                        contactList.findnext();

                    }

                    contactList.retrieve().display();

                    break;

                case 7:
                    PrintAllEvents();//
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Bad choice! Try again");
            }
            System.out.println("\n\n");
        } while (choice != 8);
    }

}
