package com.example.newsalert;

public class NewsData {
    String url;
    String urlToImage;
    String title;

    public NewsData(String url, String urlToImage,String title) {
        this.url = url;
        this.urlToImage = urlToImage;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getTitle() {
        return title;
    }
}
