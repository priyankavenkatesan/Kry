package com.kry.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kry.model.Kry;
import com.kry.repository.KryRepository;

/**
 * Service implementation of KryService
 * 
 * @author PVENKAT1
 *
 */
@Service
public class KryServiceImpl implements KryService {

	@Autowired
	KryRepository kryRepository;

	/**
	 * Method to check the connection
	 */
	@Override
	public void checkConnection() throws RuntimeException {
		String status = null;
		List<Kry> services = kryRepository.findAll();
		if (services.size() > 0) {
			for (Kry service : services) {
				try {
					URL url = new URL(service.getUrl());

					HttpURLConnection huc = (HttpURLConnection) url.openConnection();
					huc.setRequestMethod("GET");
					int responseCode = huc.getResponseCode();
					if (responseCode == 200) {
						status = "OK";
					} else {
						status = "FAIL";
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				updateService(service.getServiceName(), status);
			}
		}
	}

	/**
	 * Method to save the services
	 */
	@Override
	public String save(String url, String serviceName) {

		Kry kry = new Kry(serviceName, url, null);
		kryRepository.save(kry);
		return serviceName + " Service added Successfully";
	}

	/**
	 * method to delete the services
	 */
	@Override
	public String removeService(String name) {
		kryRepository.deleteById(name);
		return name + " Service Deleted Successfully";
	}

	/**
	 * Method to update the service
	 * 
	 * @param name
	 * @param status
	 */
	public void updateService(String name, String status) {
		if (name != null) {
			kryRepository.update(name, status);
		}
	}

	/**
	 * Method to fetch all services
	 */
	@Override
	public List<Kry> fetchServices() {
		List<Kry> services = kryRepository.findAll();
//		Map<String, String> names = new HashMap<>();
//		if (services.size() > 0) {
//			for (Kry service : services) {
//				names.put(service.getServiceName(), service.getActive());
//			}
//		} else {
//			return "No services available currently";
//		}
//		return "List of Services and Status:\n" + names.toString() + "\nLast modified on: "
//				+ services.get(services.size() - 1).getUpdatedTime() + "\nLast Service added on: "
//				+ services.get(services.size() - 1).getCreatedTime();
//	}
		return services;
		}

}
