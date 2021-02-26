package net.wredny.bardzo.wms.model;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseEntity{

	private Collection<Item> items;
	
}
