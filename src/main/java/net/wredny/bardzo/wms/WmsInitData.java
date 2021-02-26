package net.wredny.bardzo.wms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.wredny.bardzo.wms.model.Item;
import net.wredny.bardzo.wms.repositories.ItemReactiveRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
@RequiredArgsConstructor
@Slf4j
@Profile("DEV")
public class WmsInitData {

	private final ItemReactiveRepository itemReactiveRepository;

	@PostConstruct
	void initItems() {
		log.info("init wms BEGIN");
		Mono<Void> deleteMono = itemReactiveRepository.deleteAll();
		Mono<Long> countMono = itemReactiveRepository.count();
		deleteMono.then(countMono);
		deleteMono.subscribe();
		countMono.subscribe(result -> log.info("Number of items: {}", result));

		List<Item> items = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			items.add(new Item("generated" + i, "" + Math.abs(new Random().nextInt() % 1000)));
		}

		Flux<Item> itemFlux = itemReactiveRepository.saveAll(items);
		itemFlux.subscribe(item -> log.info("Saved item: {}", item));

		Mono<Long> countMonoCountAfter = itemReactiveRepository.count();

		countMonoCountAfter.subscribe(result -> log.info("Count after: {}", result));
		itemFlux.then(countMonoCountAfter);

		log.info("init wms END");
	}
}
