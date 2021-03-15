package com.example.adapter.database;

import com.example.domain.model.Fortune;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface FortuneMapper {

    Fortune map(FortuneEntity entity);

    FortuneEntity map(Fortune fortune);
}
