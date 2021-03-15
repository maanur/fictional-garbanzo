package com.example.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Map;

@Controller("/status")
public class StatusController {

    @Get
    public Map<String, String> getStatus() {
        return System.getenv();
    }
}
