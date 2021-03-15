package com.example.adapter.database;

import javax.persistence.*;

@Entity
public class FortuneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2048)
    private String text;

    public Long getId() {
        return id;
    }

    public FortuneEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public FortuneEntity setText(String text) {
        this.text = text;
        return this;
    }
}
