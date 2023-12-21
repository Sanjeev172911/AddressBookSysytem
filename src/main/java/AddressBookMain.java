import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    static Map<String, Contact>AddressBook;
    public static void takeContactsInfo(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your First Name");
        String firstName=input.next();
        System.out.println("Enter your Last Name");
        String lastName=input.next();
        System.out.println("Enter your Address");
        String address=input.nextLine();
        input.nextLine();
        System.out.println("Enter your City");
        String city=input.next();
        System.out.println("Enter your State");
        String state=input.next();
        System.out.println("Enter your Zip");
        int zip=input.nextInt();
        System.out.println("Enter your Phone Number");
        String phoneNumber=input.next();
        System.out.println("Enter your Email");
        String email=input.next();

        System.out.println("Thank You for filling the details");

        Contact newContact=new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
        AddressBook.put(firstName,newContact);
    }
    public static void main(String[] args) {
        AddressBook =new HashMap<>();
        System.out.println("Welcome to Address Book Program");
        takeContactsInfo();
    }
}
