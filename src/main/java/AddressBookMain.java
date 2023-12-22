import java.util.*;

public class AddressBookMain {
    static Scanner input=new Scanner(System.in);
    static Map<String ,TreeSet<String>>AddressBook; // storing all the first name of users living in a particular address
    public static void displayMessage(){
        System.out.println("Welcome to Address Book Program");
    }

    public static void main(String[] args) {
        AddressBook=new HashMap<>();
        ContactDetail contactDetail =new ContactDetail();
        displayMessage();

        System.out.println("Enter How Many Contacts you want to enter ");
        int numberOfContacts=input.nextInt();
        for(int i=0;i<numberOfContacts;i++){
            contactDetail.takeContactsInfo(AddressBook);
        }

        System.out.println("Do You want to Edit your Details ");
        String userInput=input.next();
        if(userInput.equalsIgnoreCase("yes")) contactDetail.editContactInfo();

        System.out.println("Do you want to delete your Contact");
        userInput=input.next();
        if(userInput.equalsIgnoreCase("yes")) contactDetail.deleteContact(AddressBook);
    }
}
