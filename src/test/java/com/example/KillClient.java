package com.example;

import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("/kill")
public interface KillClient {
    @Post
    void kill();
}
