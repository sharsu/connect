package com.inspiware.connect.organisation.model;

public class Contact {

	private Long id;
	private String name;
	private String position;

	public Contact() {

	}
	
	public Contact(String name, String position) {
		this.name = name;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", position=" + position + "]";
	}

}
