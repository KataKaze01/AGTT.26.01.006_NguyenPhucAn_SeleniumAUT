package AutomationExercise_DataObjects;

public class UserAccount {
    private String title;
    private String name;
    private String email;
    private String password;
    private String day;
    private String month;
    private String year;
    private String firstname;
    private String lastname;
    private String company;
    private String address;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;

    public UserAccount(String title, String name, String email, String password, String firstname, String lastname, String company,
                   String address, String country, String state, String city, String zipcode, String mobileNumber) {
        this.setTitle(title);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setCompany(company);
        this.setAddress(address);
        this.setCountry(country);
        this.setState(state);
        this.setCity(city);
        this.setZipcode(zipcode);
        this.setMobileNumber(mobileNumber);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
