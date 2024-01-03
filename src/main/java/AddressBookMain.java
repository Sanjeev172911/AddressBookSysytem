import java.util.*;

public class AddressBookMain {
    static Scanner input=new Scanner(System.in);
    static Map<String ,ArrayList<Contact>>AddressBook; // storing all the first name of users living in a particular address
    public static void displayMessage(){
        System.out.println("Welcome to Address Book Program");
    }

    public static void main(String[] args) {
        AddressBook= new HashMap<>();
        ContactDetail contactDetail =new ContactDetail();
        displayMessage();

        System.out.println("Enter How Many Contacts you want to enter ");
        int numberOfContacts=input.nextInt();
        for(int i=0;i<numberOfContacts;i++){
            System.out.println("Enter Name of your address book ");
            String name=input.next();
            contactDetail.takeContactsInfo(AddressBook,name);
        }

        System.out.println("Do You want to Edit your Details ");
        String userInput=input.next();
        if(userInput.equalsIgnoreCase("yes")){
            System.out.println("Enter the name of Address Book :");
            String addressBookName=input.next();
            contactDetail.editContactInfo(AddressBook,addressBookName);
        }

        for(String name:AddressBook.keySet()){
            System.out.println("Name of AddressBook is "+name);
            for(Contact contact:AddressBook.get(name)){
                System.out.println(contact.toString());
            }
        }
    }
}
