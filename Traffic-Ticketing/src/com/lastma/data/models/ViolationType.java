package com.lastma.data.models;

public enum ViolationType {
    SPEEDING("Exceeding the designated speed limit", 10000.0),
    RUNNING_RED_LIGHT("Failure to obey traffic signals / Running red light", 15000.0),
    ONE_WAY_VIOLATION("Driving against traffic flow / One-way route", 50000.0),
    ILLEGAL_PARKING("Parking in an unauthorized or restricted area", 10000.0),
    DRIVING_WITHOUT_LICENSE("Operating a vehicle without a valid driver's license", 25000.0),
    EXPIRED_VEHICLE_PAPERS("Operating vehicle with expired documentation", 15000.0),
    SEATBELT_VIOLATION("Failure to fasten seatbelt while operating vehicle", 5000.0),
    USING_PHONE_WHILE_DRIVING("Using a mobile phone while driving", 10000.0),
    RECKLESS_DRIVING("Dangerous, reckless, or negligent driving", 30000.0),
    OVERLOADING("Overloading passengers or cargo", 20000.0),
    OBSTRUCTION_OF_TRAFFIC("Causing avoidable obstruction on public roadways", 20000.0);

    private final String description;
    private final double defaultFineAmount;

    ViolationType(String description, double defaultFineAmount) {
        this.description = description;
        this.defaultFineAmount = defaultFineAmount;
    }

    public String getDescription() {
        return description;
    }

    public double getDefaultFineAmount() {
        return defaultFineAmount;
    }
}
