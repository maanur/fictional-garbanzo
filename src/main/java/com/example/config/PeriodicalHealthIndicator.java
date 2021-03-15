package com.example.config;

import io.micronaut.health.HealthStatus;
import io.micronaut.management.health.indicator.AbstractHealthIndicator;
import io.micronaut.management.health.indicator.annotation.Readiness;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.Objects;


@Singleton
@Readiness
public class PeriodicalHealthIndicator extends AbstractHealthIndicator<String> {

    private LocalDateTime maintenanceStart;

    private static final Logger log = LoggerFactory.getLogger(PeriodicalHealthIndicator.class);

    @Scheduled(fixedRate = "30s")
    public void startBackgroundTask() {
        log.info("Start background maintenance task");
        this.healthStatus = HealthStatus.DOWN;
        maintenanceStart = LocalDateTime.now();
    }

    @Override
    protected String getHealthInformation() {
        if (Objects.isNull(maintenanceStart)) {
            this.healthStatus = HealthStatus.UP;
            return "Never started";
        } else {
            LocalDateTime maintenanceEnd = maintenanceStart.plusSeconds(5);
            if (maintenanceEnd.isBefore(LocalDateTime.now())) {
                this.healthStatus = HealthStatus.UP;
                return String.format("Succeeded at %s", maintenanceEnd.toString());
            }
            return String.format("Running since %s", maintenanceStart.toString());
        }
    }

    @Override
    protected String getName() {
        return "maintenance";
    }
}
