import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    static Map<String, Contact>AddressBook;
    static Scanner input=new Scanner(System.in);
    public static void takeContactsInfo(){
        System.out.println("Enter your First Name: ");
        String firstName=input.next();
        System.out.println("Enter your Last Name: ");
        String lastName=input.next();
        input.nextLine();
        System.out.println("Enter your Address: ");
        String address=input.nextLine();
        System.out.println("Enter your City: ");
        String city=input.next();
        System.out.println("Enter your State: ");
        String state=input.next();
        System.out.println("Enter your Zip: ");
        int zip=input.nextInt();
        System.out.println("Enter your Phone Number: ");
        String phoneNumber=input.next();
        System.out.println("Enter your Email: ");
        String email=input.next();

        System.out.println("Thank You for filling the details.");

        Contact newContact=new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
        System.out.println(newContact.toString());
        AddressBook.put(firstName,newContact);
    }

    public static void editContactInfo(){
        System.out.println("Enter Your First Name: ");
        String firstName=input.next();

        if(!AddressBook.containsKey(firstName)){
            System.out.println("No Contacts with this User Name: ");
            return;
        }

        Contact user=AddressBook.get(firstName);

        System.out.println("Do you want to Edit Your Last Name: ");
        String response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value: ");
            String updatedValue=input.next();
            user.editLastName(updatedValue);
        }

        System.out.println("Do you want to edit Your Address: ");
        response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value: ");
            String updatedValue=input.nextLine();
            input.nextLine();
            user.editAddress(updatedValue);
        }

        System.out.println("Do you want to edit Your City");
        response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editCity(updatedValue);
        }

        System.out.println("Do you want to edit Your State");
        response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editState(updatedValue);
        }

        System.out.println("Do you want to edit Your Zip");
        response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value :");
            int updatedValue=input.nextInt();
            user.editZip(updatedValue);
        }

        System.out.println("Do you want to edit Your Phone Number");
        response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editPhoneNumber(updatedValue);
        }

        System.out.println("Do you want to edit Your Email");
        response=input.next();
        if(response.toLowerCase().equals("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editEmail(updatedValue);
        }

        AddressBook.put(firstName,user);
        System.out.println(user.toString());
    }

    public static void deleteContact(){
        System.out.println("Enter Your First Name");
        String firstName=input.next();

        if(!AddressBook.containsKey(firstName)){
            System.out.println("No Contacts with this user Name");
            return;
        }

        AddressBook.remove(firstName);

        System.out.println("Contact deleted successfully");
    }

    public static void displayMessage(){
        System.out.println("Welcome to Address Book Program");
    }

    public static void main(String[] args) {
        AddressBook=new HashMap<>();
        displayMessage();
        takeContactsInfo();
        System.out.println("Do You want to Edit your Details ");
        String userInput=input.next();
        if(userInput.toLowerCase().equals("yes")) editContactInfo();

        System.out.println("Do you want to delete your Contact");
        userInput=input.next();
        if(userInput.toLowerCase().equals("yes")) deleteContact();
    }
}
