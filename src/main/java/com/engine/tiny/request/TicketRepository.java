package com.engine.tiny.request;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TicketRepository extends CrudRepository<Ticket, Long> {


}
