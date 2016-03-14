package com.vivideatsfinal.model;

/**
 * Created by Ryan on 12/16/2015.
 */
public class Events {
    private int id;
    private String name;
    private int eventCount;
    private int rank;
    private String venue;
    private String city;
    private String state;
    private String performerHeroImage;
    private String categoryHeroImage;
    private String venueDisplay;
    private String startDate;
    private String dateDisplay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPerformerHeroImage() {
        return performerHeroImage;
    }

    public void setPerformerHeroImage(String performerHeroImage) {
        this.performerHeroImage = performerHeroImage;
    }

    public String getCategoryHeroImage() {
        return categoryHeroImage;
    }

    public void setCategoryHeroImage(String categoryHeroImage) {
        this.categoryHeroImage = categoryHeroImage;
    }
    public String getVenueDisplay() {
        return venueDisplay;
    }

    public void setVenueDisplay(String venueDisplay) {
        this.venueDisplay = venueDisplay;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate= startDate;
    }
    public String getDateDisplay() {
        return dateDisplay;
    }

    public void setDateDisplay(String dateDisplay) {
        this.dateDisplay = dateDisplay;
    }
}
