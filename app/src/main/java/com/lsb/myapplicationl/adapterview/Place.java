package com.lsb.myapplicationl.adapterview;

/**
 * Created by L on 2017/07/26.
 */

public class Place {
    String place;

    public Place(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Place{" +
                "place='" + place + '\'' +
                '}';
    }
}
