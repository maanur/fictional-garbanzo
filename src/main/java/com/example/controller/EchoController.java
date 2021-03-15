package com.example.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

@Controller("/echo")
public class EchoController {

    @Post
    public String echo() {
        return echo("empty");
    }

    @Post("/{var}")
    public String echo(@PathVariable(name = "var") String var) {
        return String.format("%s", var);
    }

}
