package com.wechargers.qa.frontend.data;

public enum EBrowser {
    CHROME("chrome"),
    FIREFOX("firefox");

    private String text;

    EBrowser(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
