package com.example.controller;

import com.example.config.PauseHealthIndicator;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller
public class PauseController {

    @Inject
    PauseHealthIndicator pauseHealthIndicator;

    @Post("/pause")
    public void pause() {
        pauseHealthIndicator.pause();
    }

    @Post("/unpause")
    public void unpause() {
        pauseHealthIndicator.unpause();
    }
}
