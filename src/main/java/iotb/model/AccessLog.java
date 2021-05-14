/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model;

import java.util.Date;

/**
 *
 * @author alaw8
 */
public class AccessLog {
    
    private Integer logID;
    private Integer userID;
    private Integer staffID;
    private Date accessDate;

    public AccessLog(Integer logID, Integer userID, Integer staffID, Date accessDate) {
        this.logID = logID;
        this.userID = userID;
        this.staffID = staffID;
        this.accessDate = accessDate;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
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

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }
    
    
    
}
