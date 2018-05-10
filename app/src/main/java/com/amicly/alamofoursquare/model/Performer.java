package com.amicly.alamofoursquare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darrankelinske on 1/30/18.
 */

public class Performer {

    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("image_license")
    @Expose
    private String imageLicense;
    @SerializedName("home_venue_id")
    @Expose
    private Object homeVenueId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_attribution")
    @Expose
    private String imageAttribution;
    @SerializedName("divisions")
    @Expose
    private Object divisions;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("colors")
    @Expose
    private Object colors;
    @SerializedName("home_team")
    @Expose
    private Boolean homeTeam;
    @SerializedName("away_team")
    @Expose
    private Boolean awayTeam;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImageLicense() {
        return imageLicense;
    }

    public void setImageLicense(String imageLicense) {
        this.imageLicense = imageLicense;
    }

    public Object getHomeVenueId() {
        return homeVenueId;
    }

    public void setHomeVenueId(Object homeVenueId) {
        this.homeVenueId = homeVenueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageAttribution() {
        return imageAttribution;
    }

    public void setImageAttribution(String imageAttribution) {
        this.imageAttribution = imageAttribution;
    }

    public Object getDivisions() {
        return divisions;
    }

    public void setDivisions(Object divisions) {
        this.divisions = divisions;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getColors() {
        return colors;
    }

    public void setColors(Object colors) {
        this.colors = colors;
    }

    public Boolean getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Boolean homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Boolean getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Boolean awayTeam) {
        this.awayTeam = awayTeam;
    }

}