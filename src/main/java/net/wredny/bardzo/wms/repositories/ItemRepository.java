package net.wredny.bardzo.wms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import net.wredny.bardzo.wms.model.Item;

public interface ItemRepository extends CrudRepository<Item, String> {
}