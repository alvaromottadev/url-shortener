package com.motta.service;

import com.motta.repository.UrlRepository;
import com.motta.dto.UrlShortedResponse;
import com.motta.exception.OriginalUrlNotFoundException;
import com.motta.model.Url;
import org.springframework.stereotype.Service;

import java.util.Random;

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

    public String findByShortUrl(String shortUrl){
       Url url = urlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new OriginalUrlNotFoundException("Shorturl not found."));
       return url.getOriginalUrl();
    }

    private String shortenUrl() {
        StringBuilder shortUrl = new StringBuilder();

        int lengthShortUrl = 6;

        for (int i = 0; i < lengthShortUrl; i++){
            int index = random.nextInt(ALLOWED_CHARS.length());
            shortUrl.append(ALLOWED_CHARS.charAt(index));
        }

        return shortUrl.toString();
    }

}
