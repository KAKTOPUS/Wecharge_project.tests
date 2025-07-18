package data;

public enum PagesData {
    LOGIN("login");

    private final String text;

    PagesData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
