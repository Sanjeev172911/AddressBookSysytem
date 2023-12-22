import java.util.*;

public class AddressBookMain {
    static Scanner input=new Scanner(System.in);

    public static void displayMessage(){
        System.out.println("Welcome to Address Book Program");
    }

    public static void main(String[] args) {
        AddressBook addressBook=new AddressBook();
        displayMessage();

        System.out.println("Enter How Many Contacts you want to enter ");
        int numberOfContacts=input.nextInt();
        for(int i=0;i<numberOfContacts;i++){
            addressBook.takeContactsInfo();
        }

        System.out.println("Do You want to Edit your Details ");
        String userInput=input.next();
        if(userInput.equalsIgnoreCase("yes")) addressBook.editContactInfo();

        System.out.println("Do you want to delete your Contact");
        userInput=input.next();
        if(userInput.equalsIgnoreCase("yes")) addressBook.deleteContact();
    }
}
