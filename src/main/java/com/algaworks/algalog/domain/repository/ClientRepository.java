package com.algaworks.algalog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	Optional <Client> findByEmail(String email);
	List<Client> findByNameContaining(String name);
}
