package com.example;

import com.example.domain.model.Version;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("/version")
public interface VersionClient {

    @Get
    Version getVersion();
}
