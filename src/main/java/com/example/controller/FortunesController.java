package com.example.controller;

import com.example.domain.model.Fortune;
import com.example.domain.model.NoFortunesFoundException;
import com.example.usecase.Fortunes;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/fortune")
public class FortunesController {

    @Inject
    Fortunes useCase;

    @Get("/")
    public HttpResponse<Fortune> getFortune() {
        try {
            return HttpResponse.ok(useCase.getRandomFortune());
        } catch (NoFortunesFoundException e) {
            return HttpResponse.notFound();
        }
    }

    @Get("/{id}")
    public HttpResponse<Fortune> getFortune(@PathVariable("id") Long id) {
        try {
            return HttpResponse.ok(useCase.getFortune(id));
        } catch (NoFortunesFoundException e) {
            return HttpResponse.notFound();
        }
    }

    @Post("/reload")
    public Long reloadFortunes() {
        return useCase.reloadFortunes();
    }
}
