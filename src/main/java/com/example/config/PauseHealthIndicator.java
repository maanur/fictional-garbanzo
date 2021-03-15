package com.example.config;

import io.micronaut.health.HealthStatus;
import io.micronaut.management.health.indicator.AbstractHealthIndicator;
import io.micronaut.management.health.indicator.annotation.Readiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;


@Singleton
@Readiness
public class PauseHealthIndicator extends AbstractHealthIndicator<String> {

    private static final Logger log = LoggerFactory.getLogger(PauseHealthIndicator.class);

    private boolean paused;

    public void pause() {
        log.info("Paused");
        this.paused = true;
    }

    public void unpause() {
        log.info("Unpaused");
        this.paused = false;
    }

    @Override
    protected String getHealthInformation() {
        if (paused) {
            this.healthStatus = HealthStatus.DOWN;
            return "paused";
        }
        this.healthStatus = HealthStatus.UP;
        return "running";
    }

    @Override
    protected String getName() {
        return "pause";
    }
}
