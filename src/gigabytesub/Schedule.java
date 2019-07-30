
package gigabytesub;

public class Schedule {
    
    private int schedID;
    private String day;
    private String startTime;
    private String endTime;
    private int trainerID;

    public Schedule(int schedID, String day, String startTime, String endTime, int trainerID) {
        this.schedID = schedID;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trainerID = trainerID;
    }

    public int getSchedID() {
        return schedID;
    }

    public void setSchedID(int schedID) {
        this.schedID = schedID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }
    
    
    
    
    
}
