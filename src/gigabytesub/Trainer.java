
package gigabytesub;


public class Trainer {
    
    private int TrainerID;
    private String firstName, lastName;
    private int sessionFee;

    public Trainer(int TrainerID, String firstName, String lastName, int sessionFee) {
        this.TrainerID = TrainerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sessionFee = sessionFee;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int TrainerID) {
        this.TrainerID = TrainerID;
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

    public int getSessionFee() {
        return sessionFee;
    }

    public void setSessionFee(int sessionFee) {
        this.sessionFee = sessionFee;
    }
    
    
    
}
