package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntityNotFoundException;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
	
	private DeliveryRepository deliveryRepository;
	
	public Delivery findOrElseThrow(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow( () -> new EntityNotFoundException("Delivery not found."));
	}
}
