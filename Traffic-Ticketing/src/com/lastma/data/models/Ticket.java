package com.lastma.data.models;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private int driverId;
    private int officerId;
    private String plateNumber;
    private ViolationType violationType;
    private double fineAmount;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private String location;
    private boolean isPaid;
    private double amountPaid;

    public Ticket() {
        this.issueDate = LocalDateTime.now();
        this.dueDate = this.issueDate.plusDays(14);
        this.isPaid = false;
        this.amountPaid = 0.0;
    }

    public Ticket(int driverId, int officerId, String plateNumber, ViolationType violationType, double fineAmount, String location) {
        this();
        this.driverId = driverId;
        this.officerId = officerId;
        this.plateNumber = plateNumber;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.location = location;
    }

    public Ticket(int id, int driverId, int officerId, String plateNumber, ViolationType violationType, double fineAmount, String location) {
        this(driverId, officerId, plateNumber, violationType, fineAmount, location);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public ViolationType getViolationType() {
        return violationType;
    }

    public void setViolationType(ViolationType violationType) {
        this.violationType = violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", officerId=" + officerId +
                ", plateNumber='" + plateNumber + '\'' +
                ", violationType=" + violationType +
                ", fineAmount=" + fineAmount +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", location='" + location + '\'' +
                ", isPaid=" + isPaid +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
