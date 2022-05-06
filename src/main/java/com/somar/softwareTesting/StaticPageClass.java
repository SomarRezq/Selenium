package com.somar.softwareTesting;

public class StaticPageClass {
    public String Url;
    public String TestText;

    public StaticPageClass(String url, String testText) {
        this.Url = url;
        this.TestText = testText;
    }

    public String getUrl() {
        return this.Url;
    }

    public String getTestText() {
        return this.TestText;
    }
}
