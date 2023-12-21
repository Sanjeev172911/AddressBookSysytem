public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    String phoneNumber;
    String email;

    Contact(String firstName, String lastName, String address,
            String city, String state, int zip, String phoneNumber, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
}
