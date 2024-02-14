package com.example.tripSearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

public class Trip {
    @JsonProperty("id")
    private long id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("request_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date requestDate;

    @JsonProperty("pickup_lat")
    private double pickupLat;

    @JsonProperty("pickup_lng")
    private double pickupLng;

    @JsonProperty("pickup_location")
    private String pickupLocation;

    @JsonProperty("dropoff_lat")
    private double dropoffLat;

    @JsonProperty("dropoff_lng")
    private double dropoffLng;

    @JsonProperty("dropoff_location")
    private String dropoffLocation;
    @JsonProperty("pickup_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pickupDate;
    @JsonProperty("dropoff_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dropoffDate;

    @JsonProperty("type")
    private String type;

    @JsonProperty("driver_id")
    private int driverId;

    @JsonProperty("driver_name")
    private String driverName;

    @JsonProperty("driver_rating")
    private int driverRating;

    @JsonProperty("driver_pic")
    private String driverPic;

    @JsonProperty("car_make")
    private String carMake;

    @JsonProperty("car_model")
    private String carModel;

    @JsonProperty("car_number")
    private String carNumber;

    @JsonProperty("car_year")
    private int carYear;

    @JsonProperty("car_pic")
    private String carPic;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("duration_unit")
    private String durationUnit;

    @JsonProperty("distance")
    private double distance;

    @JsonProperty("distance_unit")
    private String distanceUnit;

    @JsonProperty("cost")
    private int cost;

    @JsonProperty("cost_unit")
    private String costUnit;

    public Long getId(){
        return this.id;
    }

    public String getStatus() {
        return status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public double getPickupLat() {
        return pickupLat;
    }

    public double getPickupLng() {
        return pickupLng;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public double getDropoffLat() {
        return dropoffLat;
    }

    public double getDropoffLng() {
        return dropoffLng;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public String getType() {
        return type;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public String getDriverPic() {
        return driverPic;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getCarYear() {
        return carYear;
    }

    public String getCarPic() {
        return carPic;
    }

    public int getDuration() {
        return duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public double getDistance() {
        return distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public int getCost() {
        return cost;
    }

    public String getCostUnit() {
        return costUnit;
    }

}
