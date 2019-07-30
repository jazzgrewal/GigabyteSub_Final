

package gigabytesub;

public class Member {
    
    private int memberID;
    private String firstName, lastName,address, city ;
    private int govtID;
    private String gender;
    private int phone;
    private String email;
    private int age,planID,trainerID;

    public Member(int memberID, String firstName, String lastName, String address, String city, int govtID, String gender, int phone, String email, int age, int planID, int trainerID) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.govtID = govtID;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.planID = planID;
        this.trainerID = trainerID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGovtID() {
        return govtID;
    }

    public void setGovtID(int govtID) {
        this.govtID = govtID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }
    
    
    
    
    
}
