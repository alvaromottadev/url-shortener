package com.motta.service;

import com.motta.dto.UrlShortedResponse;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    public UrlShortedResponse shortenUrl(String originalUrl){
        return new UrlShortedResponse("");
    }

}
