package com.kry.service;

import java.util.List;

import com.kry.model.Kry;

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

	public List<Kry> fetchServices();

}
