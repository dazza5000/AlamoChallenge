
package com.amicly.alamofoursquare.model.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("dupesRemoved")
    @Expose
    private int dupesRemoved;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getDupesRemoved() {
        return dupesRemoved;
    }

    public void setDupesRemoved(int dupesRemoved) {
        this.dupesRemoved = dupesRemoved;
    }

}
