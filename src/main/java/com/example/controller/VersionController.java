package com.example.controller;

import com.example.domain.model.Version;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.server.EmbeddedServer;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/version")
public class VersionController {

    private final String host;
    private final int port;

    @Value("${micronaut.application.version}")
    private String version;

    @Inject
    VersionController(EmbeddedServer embeddedServer) {
        this.host = embeddedServer.getHost();
        this.port = embeddedServer.getPort();
    }

    @Get
    public Single<Version> getVersion() {
        Version version = new Version()
                .setVersion(this.version)
                .setHost(this.host)
                .setPort(this.port);
        return Single.just(version);
    }
}
