package com.engine.tiny.request;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("ticket")
class Ticket {

    private Long id;

    private String clientURL;

    Ticket(String clientURL) {
        this.clientURL = clientURL;
    }

    public Ticket() {
    }
}
