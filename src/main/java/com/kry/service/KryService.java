package com.kry.service;

/**
 * Service interface
 * 
 * @author PVENKAT1
 *
 */
public interface KryService {

	public String save(String url, String name);

	public void checkConnection();

	public String removeService(String name);

	public String fetchServices();

}
