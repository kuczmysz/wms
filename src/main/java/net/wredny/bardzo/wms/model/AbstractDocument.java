package net.wredny.bardzo.wms.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public abstract class AbstractDocument {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
