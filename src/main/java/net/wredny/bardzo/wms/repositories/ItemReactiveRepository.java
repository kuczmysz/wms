package net.wredny.bardzo.wms.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import net.wredny.bardzo.wms.model.Item;
import reactor.core.publisher.Flux;

public interface ItemReactiveRepository extends ReactiveCrudRepository<Item, String> {
}
