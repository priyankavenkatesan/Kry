package com.kry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kry.model.Kry;

/**
 * Repository class for Kry
 * 
 * @author PVENKAT1
 *
 */
@Transactional
@Repository
public interface KryRepository extends JpaRepository<Kry, String> {
	@Modifying
	@Query(value = "update kry k set k.active_ind= ?2 where k.service_name= ?1 ", nativeQuery = true)
	public void update(String name, String status);

}
