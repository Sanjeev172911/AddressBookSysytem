public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    Contact(String firstName, String lastName, String address,
            String city, String state, String zip, String phoneNumber, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    public String getCity(){
        return this.city;
    }

    public void editLastName(String updatedName){
        this.lastName=updatedName;
    }

    public void editAddress(String updatedAddress){
        this.address=updatedAddress;
    }

    public void editCity(String updatedCity){
        this.city=updatedCity;
    }

    public void editState(String updatedState){
        this.state=updatedState;
    }

    public void editZip(String updatedZip){
        this.zip=updatedZip;
    }

    public void editPhoneNumber(String updatedNumber){
        this.phoneNumber=updatedNumber;
    }

    public void editEmail(String updatedEmail){
        this.email=updatedEmail;
    }

    public String toString() {
        return "Contact{" +'\n'+
                    "firstName = " + firstName + '\n' +
                    "lastName = " + lastName + '\n' +
                    "address = " + address + '\n' +
                    "city = " + city + '\n' +
                    "state = " + state + '\n' +
                    "zipCode = " + zip + '\n' +
                    "phoneNumber = " + phoneNumber + '\n' +
                    "email = " + email + '\n' +
                '}';
    }
}
