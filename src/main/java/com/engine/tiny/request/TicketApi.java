package com.engine.tiny.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TicketApi {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String execute(@PathVariable Long id) {
        return ticketService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "text/plain")
    public String create(@RequestBody String clientUrl) {
        return ticketService.create(clientUrl);
    }

}
