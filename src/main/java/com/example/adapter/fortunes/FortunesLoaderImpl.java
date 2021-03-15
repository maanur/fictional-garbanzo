package com.example.adapter.fortunes;

import com.example.domain.api.FortunesLoader;
import com.example.domain.model.Fortune;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FortunesLoaderImpl implements FortunesLoader {

    private final HttpClient httpClient;
    private final String fortunesUrl;

    @Inject
    public FortunesLoaderImpl(
            @Client HttpClient httpClient,
            @Value("${micronaut.application.fortunesUrl}") String fortunesUrl
    ) {
        this.httpClient = httpClient;
        this.fortunesUrl = fortunesUrl;
    }

    @Override
    public Collection<Fortune> loadFortunes() {
        return Arrays.stream(httpClient.toBlocking().retrieve(fortunesUrl).split("\\n%\\n"))
                .map(Fortune::new)
                .collect(Collectors.toList());
    }
}
