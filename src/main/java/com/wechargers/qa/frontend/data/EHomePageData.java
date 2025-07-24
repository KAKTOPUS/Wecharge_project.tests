package com.wechargers.qa.frontend.data;

public enum EHomePageData {
    RENTALS("rents"),
    STATIONS("stations"),
    POWER_BANKS("powerbanks"),
    PAYMENTS("payments"),
    VENUE("venues"),
    CITIES("cities");

    private final String text;

    EHomePageData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
