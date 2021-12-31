package com.abdelilah.clientcommandsite.aggregates;

import com.abdelilah.coreapi.commands.CreateCustomerCommand;
import com.abdelilah.coreapi.events.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String name;
    private String email;

    public CustomerAggregate(){

    }
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command){
        log.info("CreateCustomerCommand received");
        AggregateLifecycle.apply(new CustomerCreatedEvent(
                command.getId(),
                command.getName(),
                command.getMail()
        ));
    }
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event){
        log.info("CustomerCreatedEvent occured");
        this.customerId = event.getId();
        this.name = event.getName();
        this.email = event.getMail();
    }
}
