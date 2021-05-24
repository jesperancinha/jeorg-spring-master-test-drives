package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class PartHealthIndicator implements HealthIndicator {
    private static final String[] CAR_PARTS = new String[]{"Engine", "Transmission", "Gear", "Wheel"};
    private static final Status[] STATUSES = new Status[]{Status.DOWN, Status.UNKNOWN, Status.UP, Status.OUT_OF_SERVICE};

    @Override
    public Health health() {
        int iState = (int) (STATUSES.length * Math.random());
        int iLyrics = (int) (CAR_PARTS.length * Math.random());
        return Health.status(STATUSES[iState]).withDetail("parts", CAR_PARTS[iLyrics]).build();
    }
}
