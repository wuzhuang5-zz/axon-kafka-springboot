package com.pivotal.catalog.aggregates;

import com.pivotal.catalog.commands.AddProductToCatalogCommand;
import com.pivotal.catalog.events.ProductAddEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@Slf4j
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;

    public ProductAggregate(){}

    @CommandHandler
    public ProductAggregate(AddProductToCatalogCommand command){
        log.info("Handling {} command: {}",command.getClass().getSimpleName(),command.getId(),command.getName());
        Assert.hasLength(command.getId(),"ID should NOT be empty or null.");
        Assert.hasLength(command.getName(),"Name should NOT be empty or null.");
        apply(new ProductAddEvent(command.getId(),command.getName()));
        log.info("Done handling {} command: {},{}",command.getClass().getSimpleName(),command.getId(),command.getName());
    }

    @EventSourcingHandler
    public void on(ProductAddEvent event){
        log.info("Handling {} event: {}, {}", event.getClass().getSimpleName(), event.getId(), event.getName());
    }
}
