package com.kry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kry.repository.KryRepository;
import com.kry.service.KryService;

/**
 * Controller for Kry service
 * 
 * @author PVENKAT1
 *
 */
@Controller
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
	@RequestMapping("/addService")
	@ResponseBody
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
	@RequestMapping("/removeService")
	@ResponseBody
	public String removeService(@RequestParam String name) {
		return kryService.removeService(name);
	}

	/**
	 * Method To check services every 5 mins
	 */
	@RequestMapping("/checkConnection")
	@ResponseBody
	@Scheduled(fixedRate = 50000)
	public void checkConnection() {
		kryService.checkConnection();
	}

	/**
	 * To display the services
	 * 
	 * @return
	 */
	@RequestMapping("/")
	@ResponseBody
	public String getServices() {
		return kryService.fetchServices();
	}

}
