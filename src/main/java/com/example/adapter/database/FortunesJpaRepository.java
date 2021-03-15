package com.example.adapter.database;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public interface FortunesJpaRepository extends PageableRepository<FortuneEntity, Long> {
    default Optional<FortuneEntity> getRandom() {
        long count = this.count();
        if (count <= 1) {
            return Optional.empty();
        }
        int randomIdx = ThreadLocalRandom.current().nextInt(Math.toIntExact(count));
        Page<FortuneEntity> page = this.findAll(Pageable.from(randomIdx, 1));
        return page.getContent().stream().findFirst();
    }
}
