package com.example.tripSearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TripSubset {
    @JsonProperty("id")
    private long id;

    @JsonProperty("status")
    private String status;

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

    @JsonProperty("cost")
    private int cost;

    @JsonProperty("cost_unit")
    private String costUnit;

    @JsonProperty("pickup_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pickupDate;
    @JsonProperty("dropoff_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dropoffDate;

    @JsonProperty("driver_rating")
    private int driverRating;


    // Constructors


    public TripSubset(Trip trip) {
        this.id = trip.getId();
        this.status = trip.getStatus();
        this.pickupLat = trip.getPickupLat();
        this.pickupLng = trip.getPickupLng();
        this.pickupLocation = trip.getPickupLocation();
        this.dropoffLat = trip.getDropoffLat();
        this.dropoffLng = trip.getDropoffLng();
        this.dropoffLocation = trip.getDropoffLocation();
        this.pickupDate = trip.getPickupDate();
        this.dropoffDate = trip.getDropoffDate();
        this.driverRating = trip.getDriverRating();
        this.cost = trip.getCost();
        this.costUnit = trip.getCostUnit();
    }

}
