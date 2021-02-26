package net.wredny.bardzo.wms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;

import net.wredny.bardzo.wms.model.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Service
public class ItemReactiveService {
 
    //@Autowired
    ReactiveMongoRepository<Item, String> repository;

    public Mono<Item> findById(String id) {
        return repository.findById(id);
    }
 
    public Flux<Item> findAll() {
        return repository.findAll();
    } 
    public Mono<Item> save(Item item) {
        return repository.save(item);
    }
}