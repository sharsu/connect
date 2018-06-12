package com.inspiware.connect.contact.repository;

import com.inspiware.connect.contact.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContactRepository {

	private List<Contact> contacts = new ArrayList<>();
	
	public Contact add(Contact contact) {
		contact.setId((long) (contacts.size()+1));
		contacts.add(contact);
		return contact;
	}
	
	public Contact findById(Long id) {
		Optional<Contact> contact = contacts.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (contact.isPresent())
			return contact.get();
		else
			return null;
	}
	
	public List<Contact> findAll() {
		return contacts;
	}
	
	public List<Contact> findByOrganisation(Long organisationId) {
		return contacts.stream().filter(a -> a.getOrganisationId().equals(organisationId)).collect(Collectors.toList());
	}
}
