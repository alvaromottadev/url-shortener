package com.motta.docs;

import com.motta.dto.UrlShortedResponse;
import com.motta.dto.UrlShortenRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URISyntaxException;

@Tag(name = "URL")
public interface UrlControllerSwagger {

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Url shorted with successful",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UrlShortedResponse.class, example = "{ \"shortUrl\": \"shorturl.com\" }"))
            )
    })
    @Operation(
            summary = "Shorten original url",
            description = "This endpoint is for shorten original url"
    )
    ResponseEntity<UrlShortedResponse> shortenUrl(@RequestBody UrlShortenRequest urlShortenRequest);


    @ApiResponses(value = {
            @ApiResponse(description = "Redirected with successful", responseCode = "200"),
            @ApiResponse(description = "Not found a original url from short url",
            responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UrlShortedResponse.class, example = "{ \"error\": \"Shorturl not found.\" }")))
    })
    @Operation(
            summary = "Redirect to original url from short url",
            description = "This endpoint redirect to original url using short url"
    )
    ResponseEntity<Void> redirectToOriginalUrlFromShortUrl(@PathVariable String shortUrl) throws URISyntaxException;

}
