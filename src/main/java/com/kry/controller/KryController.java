package com.kry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kry.model.Kry;
import com.kry.repository.KryRepository;
import com.kry.service.KryService;

/**
 * Controller for Kry service
 * 
 * @author PVENKAT1
 *
 */
@RestController
@EnableScheduling
public class KryController {
	@Autowired
	KryService kryService;

	@Autowired
	KryRepository kryRepository;

	/**
	 * End point to add the service
	 * 
	 * @param url
	 * @param name
	 * @return
	 */
	@PostMapping("/addService")
	public String addService(@RequestParam String url, String name) {
		String message = null;
		// URL validation
		if (url.startsWith("http")) {
			message = kryService.save(url, name);
		} else {
			message = "Given URL is not valid";
		}
		return message;
	}

	/**
	 * End point to remove the service
	 * 
	 * @param name
	 * @return
	 */
	@DeleteMapping("/removeService")
	// @RequestMapping(value="/removeService",method =
	// {RequestMethod.DELETE,RequestMethod.GET})
	public String removeService(@RequestParam String name) {
		return kryService.removeService(name);
	}

	/**
	 * Method To check services every 5 mins
	 */
	@RequestMapping("/checkConnection")
	@Scheduled(fixedRate = 50000)
	public void checkConnection() {
		kryService.checkConnection();
	}

	/**
	 * To display the services
	 * 
	 * @return
	 */
	@GetMapping("/")
	public List<Kry> getServices() {
		return kryService.fetchServices();
	}

}
