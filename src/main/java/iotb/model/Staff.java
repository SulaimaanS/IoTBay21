package iotb.model;

public class Staff {

    private Integer userID;
    private Integer staffID;

    public Staff(Integer userID, Integer staffID) {
        this.userID = userID;
        this.staffID = staffID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

}
