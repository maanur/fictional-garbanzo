package com.example.controller;

import com.example.config.KillHealthIndicator;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller("/kill")
public class KillController {

    @Inject
    KillHealthIndicator indicator;

    @Post
    public void kill() {
        indicator.kill();
    }
}
