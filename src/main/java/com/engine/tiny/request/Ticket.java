package com.engine.tiny.request;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("ticket")
class Ticket {

    private Long id;

    private String clientURL;

    static Ticket of(Long id, String clientURL) {
        return new Ticket(id, clientURL);
    }

    private Ticket(Long id, String clientURL) {
        this.clientURL = clientURL;
        this.id = id;
    }

}
