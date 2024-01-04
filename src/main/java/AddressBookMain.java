import java.util.*;

public class AddressBookMain {
    static Scanner input=new Scanner(System.in);
    static Map<String ,ArrayList<Contact>>AddressBook; // storing all the first name of users living in a particular address
    public static void displayMessage(){
        System.out.println("Welcome to Address Book Program");
    }

    public static void createNewAddressBook(String name){
        if(AddressBook.containsKey(name)){
            System.out.println("Name already taken.");
            return ;
        }

        AddressBook.put(name,new ArrayList<>());

    }

    public static void DisplayMessage(){
        System.out.println("Type 0 for Adding an Address Book");
        System.out.println("Type 1 for Adding Contact in AddressBook");
        System.out.println("Type 2 for Updating Contact in AddressBook");
        System.out.println("Type 3 for Search Contact Based on City");
        System.out.println("Type 4 for Search Contact based on state");
        System.out.println("Type 5 for view Contact Based on City");
        System.out.println("Type 6 for View Contact Based on State");
        System.out.println("Type 7 for Count of Contacts Based on City");
        System.out.println("Type 8 for Count of Contacts Based on State");
        System.out.println("Type 9 for Sort Contacts Based on Person Name");
        System.out.println("Type 10 for Sort Contacts Based on City");
        System.out.println("Type 11 for Sort Contacts Based on State");
        System.out.println("Type 12 for Sort Contacts Based on Zip");
        System.out.println("Type 13 for Creating a File");
        System.out.println("Type 14 for Reading from a File");
        System.out.println("Type 15 for Writing to a File");
    }

    public static void main(String[] args) {
        AddressBook= new HashMap<>();
        ContactDetail contactDetail =new ContactDetail();
        FileOperation fileOperation=new FileOperation();
        displayMessage();
        boolean flag=true;
        while(flag){
            DisplayMessage();
            System.out.println("Enter Test Case : ");
            String data=input.nextLine();
            int testCase=Integer.parseInt(data);
            switch(testCase){
                case 0:{
                    System.out.println("Enter your Address Book Name");
                    String addressBookName=input.nextLine();
                    createNewAddressBook(addressBookName);
                    break;
                }
                case 1:{
                    System.out.println("Enter your Address Book Name");
                    String name=input.nextLine();
                    if(!AddressBook.containsKey(name)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }
                    contactDetail.takeContactsInfo(AddressBook,name);
                    break;
                }
                case 2:{
                    System.out.println("Enter your Address Book Name");
                    String name=input.nextLine();
                    if(!AddressBook.containsKey(name)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }
                    contactDetail.editContactInfo(AddressBook,name);
                    break;
                }
                case 3:{
                    System.out.println("Enter your City Name");
                    String city=input.nextLine();
                    System.out.println("Enter Person's Name");
                    String name=input.nextLine();
                    contactDetail.searchContactBasedOnCity(city,name);
                    break;
                }
                case 4:{
                    System.out.println("Enter your State Name");
                    String state=input.nextLine();
                    System.out.println("Enter Person's Name");
                    String name=input.nextLine();
                    contactDetail.searchContactBasedOnState(state,name);
                    break;
                }
                case 5:{
                    System.out.println("Enter your City Name");
                    String city=input.nextLine();
                    contactDetail.viewContactBasedOnCity(city);
                    break;
                }
                case 6:{
                    System.out.println("Enter your State Name");
                    String state=input.nextLine();
                    contactDetail.viewContactBasedOnState(state);
                    break;
                }
                case 7:{
                    System.out.println("Enter your City Name");
                    String city=input.nextLine();
                    contactDetail.countBasedOnCity(city);
                    break;
                }
                case 8:{
                    System.out.println("Enter your State Name");
                    String state=input.nextLine();
                    contactDetail.countBasedOnState(state);
                    break;
                }
                case 9:{
                    System.out.println("Enter Name of your Address Book ");
                    String addressBookName=input.nextLine();
                    if(!AddressBook.containsKey(addressBookName)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }
                    contactDetail.sortViaPersonName(AddressBook,addressBookName);
                    break;
                }
                case 10:{
                    System.out.println("Enter Name of your Address Book ");
                    String addressBookName=input.nextLine();
                    if(!AddressBook.containsKey(addressBookName)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }
                    contactDetail.sortViaPersonsCity(AddressBook,addressBookName);
                    break;
                }
                case 11:{
                    System.out.println("Enter Name of your Address Book ");
                    String addressBookName=input.nextLine();
                    if(!AddressBook.containsKey(addressBookName)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }
                    contactDetail.sortViaPersonsState(AddressBook,addressBookName);
                    break;
                }
                case 12:{
                    System.out.println("Enter Name of your Address Book : ");
                    String addressBookName=input.nextLine();
                    if(!AddressBook.containsKey(addressBookName)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }
                    contactDetail.sortViaPersonsZip(AddressBook,addressBookName);
                    break;
                }
                case 13:{
                    System.out.println("Enter the file name to be created : ");
                    String fileName=input.nextLine();
                    fileOperation.createFile(fileName);
                    break;
                }
                case 14:{
                    System.out.println("Enter the file name you want to read from : ");
                    String fileName=input.nextLine();
                    fileOperation.readFromFile(fileName);
                    break;
                }
                case 15:{
                    System.out.println("Enter the file name you want to write on :");
                    String fileName=input.nextLine();
                    System.out.println("Enter the name of Address Book");
                    String name=input.nextLine();

                    if(!AddressBook.containsKey(name)){
                        System.out.println("No Address Book with this name.");
                        break;
                    }

                    for(Contact contact:AddressBook.get(name)){
                        fileOperation.writeToFile(fileName,contact.toString()+"\n");
                    }
                    break;
                }
                default:
                    flag=false;
                    break;
            }
        }
    }
}
