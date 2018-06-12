package com.inspiware.connect.organisation.client;

import com.inspiware.connect.organisation.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "contact-service")
public interface ContactClient {

	@GetMapping("/organisation/{organisationId}")
	List<Contact> findByOrganisation(@PathVariable("organisationId") Long organisationId);
	
}
