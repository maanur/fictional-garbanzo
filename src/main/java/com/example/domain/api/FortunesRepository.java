package com.example.domain.api;

import com.example.domain.model.Fortune;
import com.example.domain.model.NoFortunesFoundException;

import java.util.Collection;

public interface FortunesRepository {

    Fortune findById(Long id) throws NoFortunesFoundException;
    Fortune getRandom() throws NoFortunesFoundException;
    void deleteAll();
    Fortune save(Fortune fortune);
    void saveAll(Collection<Fortune> fortunes);
    long count();
}
