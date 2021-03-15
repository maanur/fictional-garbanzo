package com.example.adapter.database;

import com.example.domain.model.Fortune;
import com.example.domain.model.NoFortunesFoundException;

import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

public class FortunesRepositoryImpl implements com.example.domain.api.FortunesRepository {

    @Inject
    FortunesJpaRepository repository;

    @Inject
    FortuneMapper mapper;

    @Override
    public Fortune findById(Long id) throws NoFortunesFoundException {
        return mapper.map(repository.findById(id).orElseThrow(NoFortunesFoundException::new));
    }

    @Override
    public Fortune getRandom() throws NoFortunesFoundException {
        return mapper.map(repository.getRandom().orElseThrow(NoFortunesFoundException::new));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Fortune save(Fortune fortune) {
        return mapper.map(repository.save(mapper.map(fortune)));
    }

    @Override
    public void saveAll(Collection<Fortune> fortunes) {
        repository.saveAll(fortunes.stream().map(mapper::map).collect(Collectors.toList()));
    }

    @Override
    public long count() {
        return repository.count();
    }


}
