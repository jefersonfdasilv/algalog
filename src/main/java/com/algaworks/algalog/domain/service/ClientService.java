package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.ClientDomainException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientService {

	private ClientRepository clientRepository;
	
	public Client findOrElseThrow(Long clientId) {
		return clientRepository.findById(clientId)
				.orElseThrow( () -> new ClientDomainException("Client could not be retrieved."));
	}
	
	@Transactional
	public Client save(Client client) {
		boolean emailInUse = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(c -> !c.equals(client));
		if(emailInUse) {
			throw new ClientDomainException("Email is already in use");
		}
		return clientRepository.save(client);
	}
	
	public void delete(Long clientID) {
		clientRepository.deleteById(clientID);
	}
}
