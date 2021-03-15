package com.example.controller;

import com.example.config.KillLivenessHealthIndicator;
import com.example.config.KillReadinessHealthIndicator;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller("/kill")
public class KillController {

    @Inject
    KillReadinessHealthIndicator readinessHealthIndicator;

    @Inject
    KillLivenessHealthIndicator livenessHealthIndicator;

    @Post
    public void kill() {
        readinessHealthIndicator.kill();
        livenessHealthIndicator.kill();
    }
}
