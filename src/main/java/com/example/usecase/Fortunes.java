package com.example.usecase;

import com.example.domain.api.FortunesRepository;
import com.example.domain.api.FortunesLoader;
import com.example.domain.model.Fortune;
import com.example.domain.model.NoFortunesFoundException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Fortunes {

    private final FortunesRepository repository;

    private final FortunesLoader loader;

    @Inject
    public Fortunes(FortunesRepository repository, FortunesLoader loader) {
        this.repository = repository;
        this.loader = loader;
    }

    public Fortune getFortune(Long id) throws NoFortunesFoundException {
        return repository.findById(id);
    }

    public Fortune getRandomFortune() throws NoFortunesFoundException {
        return repository.getRandom();
    }

    public Long reloadFortunes() {
        repository.deleteAll();
        repository.saveAll(loader.loadFortunes());
        return repository.count();
    }
}
