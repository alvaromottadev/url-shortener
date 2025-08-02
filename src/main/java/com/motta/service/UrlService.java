package com.motta.service;

import com.motta.UrlRepository;
import com.motta.dto.UrlShortedResponse;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public UrlShortedResponse shortenUrl(String originalUrl){
        return new UrlShortedResponse("");
    }

}
