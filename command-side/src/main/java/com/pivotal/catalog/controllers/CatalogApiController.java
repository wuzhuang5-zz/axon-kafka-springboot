package com.pivotal.catalog.controllers;

import com.pivotal.catalog.commands.AddProductToCatalogCommand;
import com.pivotal.catalog.services.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class CatalogApiController {
    @Autowired
    private CatalogService catalogService;

    @PostMapping("/add")
    public CompletableFuture<String> addProductToCatalog(@RequestBody Map<String,String> request){
        AddProductToCatalogCommand command = new AddProductToCatalogCommand(request.get("id"),request.get("name"));
        log.info("Executing command: {}");
        return catalogService.addProductToCatalog(command);
    }
}
