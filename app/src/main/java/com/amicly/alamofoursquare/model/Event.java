package com.amicly.alamofoursquare.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by darrankelinske on 1/30/18.
 */

public class Event {
    @SerializedName("date_tbd")
    @Expose
    private Boolean dateTbd;
    @SerializedName("time_tbd")
    @Expose
    private Boolean timeTbd;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("visible_until_utc")
    @Expose
    private String visibleUntilUtc;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("datetime_utc")
    @Expose
    private String datetimeUtc;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("short_title")
    @Expose
    private String shortTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("datetime_tbd")
    @Expose
    private Boolean datetimeTbd;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("announce_date")
    @Expose
    private String announceDate;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("datetime_local")
    @Expose
    private String datetimeLocal;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("general_admission")
    @Expose
    private Boolean generalAdmission;
    @SerializedName("performers")
    @Expose
    private List<Performer> performers = null;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    private boolean isFavorite;

    public Boolean getDateTbd() {
        return dateTbd;
    }

    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    public Boolean getTimeTbd() {
        return timeTbd;
    }

    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
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

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
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

    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getGeneralAdmission() {
        return generalAdmission;
    }

    public void setGeneralAdmission(Boolean generalAdmission) {
        this.generalAdmission = generalAdmission;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
