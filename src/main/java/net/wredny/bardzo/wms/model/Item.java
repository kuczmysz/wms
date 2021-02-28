package net.wredny.bardzo.wms.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class Item extends BaseEntity {

	public Item(String name, String code) {
		this.setName(name);
		this.setCode(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
