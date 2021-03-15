package com.example;

import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("/echo")
public interface EchoClient {

    @Post
    String postEmpty();

    @Post("/{var}")
    String postVar(@PathVariable(name = "var") String var);

}
