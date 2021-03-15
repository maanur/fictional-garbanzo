package com.example.config;

import com.example.usecase.Fortunes;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.management.health.indicator.HealthIndicator;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Inject;

@Context
public class SimpleConfig {

    @Inject
    Fortunes fortunes;

    @EventListener
    void onStartup(StartupEvent event) {
        fortunes.reloadFortunes();
    }
}
