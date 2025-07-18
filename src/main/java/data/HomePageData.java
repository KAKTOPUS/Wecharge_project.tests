package data;

public enum HomePageData {
    RENTALS("rents"),
    STATIONS("stations"),
    POWER_BANKS("powerbanks"),
    PAYMENTS("payments"),
    VENUE("venues"),
    CITIES("cities");

    private final String text;

    HomePageData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
