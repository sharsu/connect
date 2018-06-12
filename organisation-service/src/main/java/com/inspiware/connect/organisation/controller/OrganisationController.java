package com.inspiware.connect.organisation.controller;

import java.util.List;

import com.inspiware.connect.organisation.model.Organisation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.inspiware.connect.organisation.client.ContactClient;
import com.inspiware.connect.organisation.repository.OrganisationRepository;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganisationController.class);
	
	@Autowired
	OrganisationRepository repository;
	@Autowired
    ContactClient contactClient;
	
	@PostMapping
	public Organisation add(@RequestBody Organisation organisation) {
		LOGGER.info("Organisation add: {}", organisation);
		return repository.add(organisation);
	}

	/**
	 * Retrieves all client details in Rainmaker
	 * @return A collection of clients
	 */
	@GetMapping
	public List<Organisation> findAll() {
		LOGGER.info("Organisation find");
		return repository.findAll();
	}

	/**
	 * Retrieves client details by identifier.
	 * @param id Unique client identifier
	 * @return Client details in JSON format
	 */
	@GetMapping("/{id}")
	public Organisation findById(@PathVariable("id") Long id) {
		LOGGER.info("Organisation find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/{id}/with-contacts")
	public Organisation findByIdWithContacts(@PathVariable("id") Long id) {
		LOGGER.info("Organisation find: id={}", id);
		Organisation organisation = repository.findById(id);
		// organisation.setContacts(contactClient.findByOrganisation(organisation.getId()));
		return organisation;
	}

	/**
	 * Handles <code>EmptyResultDataAccessException</code> object, returning
	 * HTTP Status 404.
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Organisation not found")
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public void exceptionHandler(){	}
	
}
