package com.motta.controller;

import com.motta.docs.UrlControllerSwagger;
import com.motta.dto.UrlShortedResponse;
import com.motta.dto.UrlShortenRequest;
import com.motta.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UrlController implements UrlControllerSwagger {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<UrlShortedResponse> shortenUrl(@Validated @RequestBody UrlShortenRequest urlShortenRequest)  {
        UrlShortedResponse response = urlService.findOrCreateShortUrl(urlShortenRequest.originalUrl());
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrlFromShortUrl(@PathVariable String shortUrl) throws URISyntaxException {
        String originalUrl = this.urlService.findByShortUrl(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(originalUrl));
        return new ResponseEntity<>(headers,HttpStatus.MOVED_PERMANENTLY);
    }

}
