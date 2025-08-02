package com.motta.service;

import com.motta.UrlRepository;
import com.motta.dto.UrlShortedResponse;
import com.motta.model.Url;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final Random random = new Random();

    private static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlShortedResponse findOrCreateShortUrl(String originalUrl){
        Url url = findByOriginalUrl(originalUrl);
        if (url != null) return new UrlShortedResponse(url.getShortUrl());

        String shortUrl = shortenUrl();

        url = new Url(originalUrl, shortUrl);
        urlRepository.save(url);

        return new UrlShortedResponse(shortUrl);
    }

    private Url findByOriginalUrl(String originalUrl){
        return urlRepository.findByOriginalUrl(originalUrl);
    }

    private String shortenUrl() {
        StringBuilder shortUrl = new StringBuilder();

        int LENGTH_SHORT_URL = 6;

        for (int i = 0; i < LENGTH_SHORT_URL; i++){
            int index = random.nextInt(ALLOWED_CHARS.length());
            shortUrl.append(ALLOWED_CHARS.charAt(index));
        }

        return shortUrl.toString();
    }

}
