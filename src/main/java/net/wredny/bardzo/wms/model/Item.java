package net.wredny.bardzo.wms.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
public class Item extends BaseEntity {

	public Item(String name, String code) {
		this.setName(name);
		this.setCode(code);
	}
}
