package org.crusadia.avramax.config;

import io.vertx.ext.web.Router;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;


@ApplicationScoped
public class CorsFilter {

    void onStart(@Observes Router router) {
        router.route().handler(rc -> {
            rc.response()
                    .putHeader("Access-Control-Allow-Origin", "http://localhost:4200")
                    .putHeader("Access-Control-Allow-Credentials", "true")
                    .putHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                    .putHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

            if ("OPTIONS".equalsIgnoreCase(rc.request().method().name())) {
                rc.response().setStatusCode(204).end();
            } else {
                rc.next();
            }
        });
    }
}