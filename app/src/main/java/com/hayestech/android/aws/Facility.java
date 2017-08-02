package com.hayestech.android.aws;

/**
 * Created by Eric on 8/1/2017.
 */

public class Facility {

    private String address;
    private String siteNumber;

    public String getAddress() {
        return address;
    }

    public String getSiteNumber() {
        return siteNumber;
    }

    public Facility(String siteNumber) {
        this.siteNumber = siteNumber;
    }

    public Facility(String address, String siteNumber) {
        this.address = address;
        this.siteNumber = siteNumber;
    }
}
