package com.example.domain.api;

import com.example.domain.model.Fortune;

import java.util.Collection;

public interface FortunesLoader {
    Collection<Fortune> loadFortunes();
}
