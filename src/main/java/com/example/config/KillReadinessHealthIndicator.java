package com.example.config;

import io.micronaut.health.HealthStatus;
import io.micronaut.management.health.indicator.AbstractHealthIndicator;
import io.micronaut.management.health.indicator.annotation.Liveness;
import io.micronaut.management.health.indicator.annotation.Readiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
@Readiness
public class KillReadinessHealthIndicator extends AbstractHealthIndicator<String> {

    private static final Logger log = LoggerFactory.getLogger(KillReadinessHealthIndicator.class);

    public KillReadinessHealthIndicator() {
        super();
        this.healthStatus = HealthStatus.UP;
    }

    public void kill() {
        log.info("Execution stopped by /kill command");
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
