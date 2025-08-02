package com.motta.controller;

import com.motta.dto.UrlShortedResponse;
import com.motta.dto.UrlShortenRequest;
import com.motta.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<UrlShortedResponse> shortenUrl(@RequestBody UrlShortenRequest urlShortenRequest)  {
        UrlShortedResponse response = urlService.findOrCreateShortUrl(urlShortenRequest.originalUrl());
        return ResponseEntity.status(201).body(response);
    }

}
