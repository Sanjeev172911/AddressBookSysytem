import com.sun.source.tree.Tree;

import java.util.*;

public class ContactDetail {
    private static Map<String, Contact> ContactDetails;
    static Scanner input=new Scanner(System.in);
    ContactDetail(){
        ContactDetails=new HashMap<>();
    }

    public static Map<String, Contact> getContactDetails() {
        return ContactDetails;
    }


    public boolean isDuplicateName(ArrayList<Contact>contacts,String firstName){
        for(Contact contact:contacts){
            if(contact.getFirstName().equals(firstName)){
               return true;
            }
        }
        return false;
    }


    public void takeContactsInfo(Map<String , ArrayList<Contact>>AddressBook, String nameOfAddressBook){
        System.out.println("Enter your First Name: ");
        String firstName=input.next();

        if(AddressBook.containsKey(nameOfAddressBook)){
            while(isDuplicateName(AddressBook.get(nameOfAddressBook),firstName)){
                System.out.println("This name is already taken , Please Re-enter your first Name");
                firstName=input.next();
            }
        }

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
        ContactDetails.put(firstName,newContact);

        if(AddressBook.containsKey(nameOfAddressBook))AddressBook.get(nameOfAddressBook).add(newContact);
        else{
            ArrayList<Contact>contacts=new ArrayList<>();
            contacts.add(newContact);
            AddressBook.put(nameOfAddressBook,contacts);
        }
    }

    public void isContactAvailable(ArrayList<Contact> contacts, String firstName){
        Contact user=null;
        for(Contact contact:contacts){
            if(contact.getFirstName().equals(firstName)){
                user=contact;
            }
        }

        if(user==null){
            System.out.println(firstName+" not available in Address Book");
            return;
        }

        System.out.println("Do you want to Edit Your Last Name: ");
        String response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value: ");
            String updatedValue=input.next();
            user.editLastName(updatedValue);
        }

        System.out.println("Do you want to edit Your Address: ");
        response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value: ");
            String updatedValue=input.nextLine();
            input.nextLine();
            user.editAddress(updatedValue);
        }

        System.out.println("Do you want to edit Your City");
        response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editCity(updatedValue);
        }

        System.out.println("Do you want to edit Your State");
        response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editState(updatedValue);
        }

        System.out.println("Do you want to edit Your Zip");
        response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            int updatedValue=input.nextInt();
            user.editZip(updatedValue);
        }

        System.out.println("Do you want to edit Your Phone Number");
        response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editPhoneNumber(updatedValue);
        }

        System.out.println("Do you want to edit Your Email");
        response=input.next();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editEmail(updatedValue);
        }

        ContactDetails.put(firstName,user);
        System.out.println(user.toString());
    }

    public void editContactInfo(Map<String , ArrayList<Contact>>AddressBook, String nameOfAddressBook){
        if(!AddressBook.containsKey(nameOfAddressBook)){
            System.out.println("No address book with this name exist");
            return ;
        }
        System.out.println("Enter Your First Name: ");
        String firstName=input.next();

        isContactAvailable(AddressBook.get(nameOfAddressBook),firstName);

    }

    public static void deleteContact(Map<String ,TreeSet<String>>AddressBook){
        System.out.println("Enter Your First Name");
        String firstName=input.next();

        if(!ContactDetails.containsKey(firstName)){
            System.out.println("No Contacts with this user Name");
            return;
        }

        String address=ContactDetails.get(firstName).getCity();
        AddressBook.get(address).remove(firstName);
        ContactDetails.remove(firstName);

        System.out.println("Contact deleted successfully");
    }
}
