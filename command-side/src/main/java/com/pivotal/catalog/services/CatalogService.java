package com.pivotal.catalog.services;

import com.pivotal.catalog.commands.AddProductToCatalogCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CatalogService {

    private CommandGateway commandGateway;

    public CatalogService(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> addProductToCatalog(AddProductToCatalogCommand command){
        log.info("processing AddProductToCatalogCommand command:{}");
        return this.commandGateway.send(command);
    }
}
