package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.OccurrenceAssembler;
import com.algaworks.algalog.api.model.request.OccurrenceModelRequest;
import com.algaworks.algalog.api.model.response.OccurrenceModelResponse;
import com.algaworks.algalog.domain.service.OccurrenceRegistrationService;
import com.algaworks.algalog.domain.service.SearchDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

	private OccurrenceRegistrationService occurrenceRegistrationService;
	private OccurrenceAssembler assembler;
	private SearchDeliveryService searchDeliveryService;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceModelResponse register(@PathVariable Long deliveryId,
			@Valid @RequestBody OccurrenceModelRequest occurrenceModelRequest) {
			
		var occurrence = occurrenceRegistrationService.register(deliveryId, occurrenceModelRequest.getDescription());
		
		return assembler.toModel(occurrence);
		
	}
	
	@GetMapping
	public List<OccurrenceModelResponse> list(@PathVariable Long deliveryId){
		var delivery = searchDeliveryService.findOrElseThrow(deliveryId);
		var occurrences = delivery.getOccurrences();
		return assembler.toCollectionModel(occurrences);
	}
}
