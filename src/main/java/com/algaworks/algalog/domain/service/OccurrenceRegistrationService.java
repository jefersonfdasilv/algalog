package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OccurrenceRegistrationService {
	
	private SearchDeliveryService searchDeliveryService;
	
	@Transactional
	public Occurrence register(Long deliveryId, String description) {
		var delivery = searchDeliveryService.findOrElseThrow(deliveryId);
		return delivery.addOccurrence(description);
	}
}
