package com.ait.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    // Class body can be left empty for automatic scanning of resources
    // Resources and providers can be registered explicitly here if needed
}
