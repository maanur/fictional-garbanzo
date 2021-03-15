package com.example.config;

import com.example.usecase.Fortunes;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Inject;

@Context
public class SimpleConfig {

    @Inject
    Fortunes fortunes;

    @Inject
    PauseHealthIndicator pauseHealthIndicator;

    @EventListener
    void loadFortunesOnStartup(StartupEvent event) {
        fortunes.reloadFortunes();
    }

    @EventListener
    void unpauseOnStartup(StartupEvent event) { pauseHealthIndicator.unpause(); }
}
