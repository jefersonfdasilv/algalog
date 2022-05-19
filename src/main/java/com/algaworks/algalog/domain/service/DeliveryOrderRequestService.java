package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryOrderRequestService {
	
	private DeliveryRepository deliveryRepository;
	private ClientService clientService;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		
		Client client = clientService.findOrElseThrow(delivery.getClient().getId());
		
		delivery.setClient(client);
		
		return deliveryRepository.save(delivery);
	}
}
