package com.example;

import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface PauseClient {
    @Post("/pause")
    void pause();

    @Post("/unpause")
    void unpause();
}
