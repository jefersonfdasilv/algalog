package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizeDeliveryService {
	
	private SearchDeliveryService deliveryService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public void end(Long deliveryId) {
		var delivery = deliveryService.findOrElseThrow(deliveryId);
		
		delivery.endNow();
		
		deliveryRepository.save(delivery);
	}
	
}
