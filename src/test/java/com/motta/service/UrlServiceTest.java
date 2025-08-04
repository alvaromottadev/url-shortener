package com.motta.service;

import com.motta.dto.UrlShortedResponse;
import com.motta.exception.OriginalUrlNotFoundException;
import com.motta.model.Url;
import com.motta.repository.UrlRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class UrlServiceTest {

    @InjectMocks
    private UrlService urlService;

    @Mock
    private UrlRepository urlRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return shortened url when founded by original url")
    void shouldReturnShortedUrlByOriginalUrl(){

        String originalUrl = "https://example.com";

        Url mockUrl = new Url(UUID.randomUUID().toString(), "https://example.com", "an35sd");
        when(urlRepository.findByOriginalUrl("https://example.com")).thenReturn(mockUrl);

        UrlShortedResponse expected = new UrlShortedResponse("an35sd");
        UrlShortedResponse actual = this.urlService.findOrCreateShortUrl(originalUrl);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Should return shortened url by method shorten")
    void shouldReturnShortedUrlByMethodShorten(){

        String originalUrl = "https://example.com";
        Url url = null;

        when(urlRepository.findByOriginalUrl("https://example.com")).thenReturn(url);

        var actual = this.urlService.findOrCreateShortUrl(originalUrl);

        verify(urlRepository, times(1)).save(any());

        Assertions.assertInstanceOf(UrlShortedResponse.class, actual);

    }

    @Test
    @DisplayName("Should return original url from short url")
    void shouldReturnOriginalUrlFromShortUrl(){

        String shortUrl = "https://example.com/an35sd";
        Url url = new Url(UUID.randomUUID().toString(), "https://example.com", "an35sd");

        when(urlRepository.findByShortUrl("https://example.com/an35sd")).thenReturn(Optional.of(url));

        String expected = "https://example.com";
        String actual = this.urlService.findByShortUrl(shortUrl);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Should return exception when not found original url from shorturl")
    void shouldReturnOriginalUrlFromShortUrlWhenNotFound(){

        String shortUrl = "https://example.com/an35sd";

        when(urlRepository.findByShortUrl(shortUrl)).thenReturn(Optional.empty());

        OriginalUrlNotFoundException exception = Assertions.assertThrows(OriginalUrlNotFoundException.class,
                () -> this.urlService.findByShortUrl(shortUrl));

        Assertions.assertEquals("Shorturl not found.", exception.getMessage());

    }


}
