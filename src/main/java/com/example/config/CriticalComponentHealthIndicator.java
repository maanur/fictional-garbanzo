package com.example.config;

import io.micronaut.health.HealthStatus;
import io.micronaut.management.health.indicator.AbstractHealthIndicator;
import io.micronaut.management.health.indicator.annotation.Liveness;

import javax.inject.Singleton;

@Singleton
@Liveness
public class CriticalComponentHealthIndicator extends AbstractHealthIndicator<String> {

    public CriticalComponentHealthIndicator() {
        super();
        this.healthStatus = HealthStatus.UP;
    }

    public void down() {
        this.healthStatus = HealthStatus.DOWN;
    }

    @Override
    protected String getHealthInformation() {
        return "n/a";
    }

    @Override
    protected String getName() {
        return "critical dependency";
    }
}
