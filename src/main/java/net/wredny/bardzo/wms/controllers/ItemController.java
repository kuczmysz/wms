package net.wredny.bardzo.wms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.wredny.bardzo.wms.model.Item;
import net.wredny.bardzo.wms.repositories.ItemReactiveRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/item")
@RequiredArgsConstructor
class ItemController {

	@Autowired
	private ItemReactiveRepository repository;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Mono<Item> get(@PathVariable String id) {
		return repository.findById(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/all")//, produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<Item> getAll() {
		Flux<Item> items = repository.findAll();
		return items;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Mono<Item> save(@RequestBody Item item) {
		Mono<Item> savedItem = repository.save(item);
		return savedItem;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable String id) {
		return repository.deleteById(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/all")
	public Flux<Item> saveAll(@RequestBody Flux<Item> items) {
		return repository.saveAll(items);
	}

}