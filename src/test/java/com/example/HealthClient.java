package com.example;

import io.micronaut.health.HealthStatus;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("/health")
public interface HealthClient {
    @Get
    HttpResponse<HealthStatus> health();

    @Get("/readiness")
    HttpResponse<HealthStatus> readiness();

    @Get("/liveness")
    HttpResponse<HealthStatus> liveness();
}
