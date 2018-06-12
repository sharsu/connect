package com.inspiware.connect.contact.controller;

import java.util.List;

import com.inspiware.connect.contact.model.Contact;
import com.inspiware.connect.contact.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
    ContactRepository repository;
	
	@PostMapping("/")
	public Contact add(@RequestBody Contact contact) {
		LOGGER.info("Contact add: {}", contact);
		return repository.add(contact);
	}
	
	@GetMapping("/{id}")
	public Contact findById(@PathVariable("id") Long id) {
		LOGGER.info("Contact find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Contact> findAll() {
		LOGGER.info("Contact find");
		return repository.findAll();
	}
	
	@GetMapping("/organisation/{organisationId}")
	public List<Contact> findByOrganisation(@PathVariable("organisationId") Long organisationId) {
		LOGGER.info("Contact find: organisationId={}", organisationId);
		return repository.findByOrganisation(organisationId);
	}
}
