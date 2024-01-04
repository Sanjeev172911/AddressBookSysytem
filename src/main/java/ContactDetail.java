import com.sun.source.tree.Tree;

import java.util.*;

public class ContactDetail {
    private static Map<String, ArrayList<Contact>> ContactDetailsBasedOnCity;
    private static Map<String, ArrayList<Contact>> ContactDetailsBasedOnState;
    static Scanner input=new Scanner(System.in);

    ContactDetail() {
       ContactDetailsBasedOnCity=new HashMap<>();
       ContactDetailsBasedOnState=new HashMap<>();
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
                firstName=input.nextLine();
            }
        }

        System.out.println("Enter your Last Name: ");
        String lastName=input.nextLine();
        System.out.println("Enter your Address: ");
        String address=input.nextLine();
        System.out.println("Enter your City: ");
        String city=input.nextLine();
        System.out.println("Enter your State: ");
        String state=input.nextLine();
        System.out.println("Enter your Zip: ");
        String zip=input.nextLine();
        System.out.println("Enter your Phone Number: ");
        String phoneNumber=input.nextLine();
        System.out.println("Enter your Email: ");
        String email=input.nextLine();

        System.out.println("Thank You for filling the details.");

        Contact newContact=new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
        System.out.println(newContact.toString());

        if(ContactDetailsBasedOnState.containsKey(state)) ContactDetailsBasedOnState.get(state).add(newContact);
        else {
            ArrayList<Contact>contacts=new ArrayList<>();
            contacts.add(newContact);
            ContactDetailsBasedOnState.put(state,contacts);
        }

        if(ContactDetailsBasedOnCity.containsKey(city)) ContactDetailsBasedOnCity.get(state).add(newContact);
        else {
            ArrayList<Contact>contacts=new ArrayList<>();
            contacts.add(newContact);
            ContactDetailsBasedOnCity.put(city,contacts);
        }

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
        String response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value: ");
            String updatedValue=input.nextLine();
            user.editLastName(updatedValue);
        }

        System.out.println("Do you want to edit Your Address: ");
        response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value: ");
            String updatedValue=input.nextLine();
            input.nextLine();
            user.editAddress(updatedValue);
        }

        System.out.println("Do you want to edit Your City");
        response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.next();
            user.editCity(updatedValue);
        }

        System.out.println("Do you want to edit Your State");
        response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.nextLine();
            user.editState(updatedValue);
        }

        System.out.println("Do you want to edit Your Zip");
        response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.nextLine();
            user.editZip(updatedValue);
        }

        System.out.println("Do you want to edit Your Phone Number");
        response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.nextLine();
            user.editPhoneNumber(updatedValue);
        }

        System.out.println("Do you want to edit Your Email");
        response=input.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Enter the updated value :");
            String updatedValue=input.nextLine();
            user.editEmail(updatedValue);
        }

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

    public void searchContactBasedOnCity(String city,String person){
        boolean flag=false;
        if(ContactDetailsBasedOnCity.containsKey(city)){
            for(Contact contact:ContactDetailsBasedOnCity.get(city)){
                if(contact.getFirstName().equals(person)){
                    System.out.println(contact.toString());
                    flag=true;
                }
            }
        }
        if(!flag) System.out.println("No contacts found with this "+person+" name in "+city);
    }

    public void searchContactBasedOnState(String state,String person){
        boolean flag=false;
        if(ContactDetailsBasedOnCity.containsKey(state)){
            for(Contact contact:ContactDetailsBasedOnState.get(state)){
                if(contact.getFirstName().equals(person)){
                    System.out.println(contact.toString());
                    flag=true;
                }
            }
        }

        if(!flag) System.out.println("No contacts found with this "+person+" name in "+state);
    }


    public void viewContactBasedOnCity(String city){
        boolean flag=false;
        if(ContactDetailsBasedOnCity.containsKey(city)){
            for(Contact contact:ContactDetailsBasedOnCity.get(city)){
                    System.out.println(contact.toString());
                    flag=true;
            }
        }
        if(!flag) System.out.println("No contacts found in "+city);
    }

    public void viewContactBasedOnState(String state){
        boolean flag=false;
        if(ContactDetailsBasedOnCity.containsKey(state)){
            for(Contact contact:ContactDetailsBasedOnState.get(state)){
                    System.out.println(contact.toString());
                    flag=true;
            }
        }

        if(!flag) System.out.println("No contacts found in "+state);
    }

    public int countBasedOnCity(String city){
        if(ContactDetailsBasedOnCity.containsKey(city)){
            return ContactDetailsBasedOnCity.get(city).size();
        }

        return 0;
    }

    public int countBasedOnState(String state){
        if(ContactDetailsBasedOnState.containsKey(state)){
            return ContactDetailsBasedOnState.get(state).size();
        }

        return 0;
    }

    public void sortViaPersonName(Map<String , ArrayList<Contact>>AddressBook, String nameOfAddressBook){
        ArrayList<Contact>contacts=AddressBook.get(nameOfAddressBook);
        Comparator<Contact> firstNameComparator = Comparator.comparing(Contact::getFirstName);
        Collections.sort(contacts,firstNameComparator);

        for(Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }


    public void sortViaPersonsCity(Map<String , ArrayList<Contact>>AddressBook, String nameOfAddressBook){
        ArrayList<Contact>contacts=AddressBook.get(nameOfAddressBook);
        Comparator<Contact> cityComparator = Comparator.comparing(Contact::getCity);
        Collections.sort(contacts,cityComparator);

        for(Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }

    public void sortViaPersonsState(Map<String , ArrayList<Contact>>AddressBook, String nameOfAddressBook){
        ArrayList<Contact>contacts=AddressBook.get(nameOfAddressBook);
        Comparator<Contact> stateComparator = Comparator.comparing(Contact::getState);
        Collections.sort(contacts,stateComparator);

        for(Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }

    public void sortViaPersonsZip(Map<String , ArrayList<Contact>>AddressBook, String nameOfAddressBook){
        ArrayList<Contact>contacts=AddressBook.get(nameOfAddressBook);
        Comparator<Contact> zipComparator = Comparator.comparing(Contact::getZip);

        Collections.sort(contacts,zipComparator);

        for(Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }
    
}
