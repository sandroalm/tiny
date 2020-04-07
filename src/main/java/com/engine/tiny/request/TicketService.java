package com.engine.tiny.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class TicketService {

    @Value("${short.url}")
    private String url;

    @Autowired
    private TicketRepository repository;

    String find(Long id) {
        return repository.findById(id)
                .map(t -> t.getClientURL())
                .orElseThrow(IllegalArgumentException::new);
    }

    String create(String clientURL) {
        final Ticket saved = repository.save(new Ticket(clientURL));
        return url + saved.getId();
    }


}
