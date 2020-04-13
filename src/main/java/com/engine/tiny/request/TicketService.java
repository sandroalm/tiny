package com.engine.tiny.request;

import com.engine.tiny.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class TicketService {

    @Value("${short.url}")
    private String url;

    @Autowired
    private TicketRepository repository;

    @Autowired
    private RedisService redisService;

    String find(Long id) {
        return repository.findById(id)
                .map(t -> t.getClientURL())
                .orElseThrow(IllegalArgumentException::new);
    }

    String create(String clientURL) {
        final Long id = redisService.nextId();
        final Ticket saved = repository.save(Ticket.of(id, clientURL));
        return url + saved.getId();
    }

}
