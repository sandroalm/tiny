package com.engine.tiny.request;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientURL;

    Ticket(String clientURL) {
        this.clientURL = clientURL;
    }

    public Ticket() {
    }
}
