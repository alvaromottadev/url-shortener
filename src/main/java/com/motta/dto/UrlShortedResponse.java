package com.motta.dto;

public record UrlShortedResponse(

        String shortUrl

) {

    public UrlShortedResponse(String shortUrl) {
        this.shortUrl = "http://localhost:8080/" + shortUrl;
    }

}
