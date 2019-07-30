
package gigabytesub;


public class Plan {
    private int planID;;
    private String planName;
    private int monthlyFee;
    private String description;

    public Plan(int planID, String planName, int monthlyFee, String description) {
        this.planID = planID;
        this.planName = planName;
        this.monthlyFee = monthlyFee;
        this.description = description;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
