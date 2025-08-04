package com.motta.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlShortenRequest(

        @NotBlank(message = "Original url is required")
        String originalUrl

) {
}
