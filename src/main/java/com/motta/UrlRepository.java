package com.motta;

import com.motta.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, String> {

    Url findByOriginalUrl(String originalUrl);

    Optional<Url> findByShortUrl(String shortUrl);

}
