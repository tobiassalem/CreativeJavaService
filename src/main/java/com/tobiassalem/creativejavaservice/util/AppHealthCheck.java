package com.tobiassalem.creativejavaservice.util;

import com.codahale.metrics.health.HealthCheck;

public class AppHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        if (Runtime.getRuntime() != null) {
            return Result.healthy();
        } else {
            return Result.unhealthy("App could not start runtime.");
        }

    }
}
