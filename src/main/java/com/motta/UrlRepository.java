package com.motta;

import com.motta.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {

    Url findByOriginalUrl(String originalUrl);

    Url findByShortUrl(String shortUrl);

}
