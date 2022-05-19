package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.DeliveryAssembler;
import com.algaworks.algalog.api.model.request.DeliveryModelRequest;
import com.algaworks.algalog.api.model.response.DeliveryModelResponse;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.DeliveryOrderRequestService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	private DeliveryOrderRequestService deliveryOrderRequestService;
	private DeliveryRepository deliveryRepository;
	private DeliveryAssembler deliveryAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryModelResponse request(@Valid @RequestBody DeliveryModelRequest deliveryModelRequest) {
		
		var delivery = deliveryAssembler.toEntity(deliveryModelRequest);
		
		var deliveryOrder = deliveryOrderRequestService.request(delivery);

		return deliveryAssembler.toModel(deliveryOrder);
	}

	@GetMapping
	public List<DeliveryModelResponse> listAll() {
		return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}

	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryModelResponse> find(@PathVariable Long deliveryId) {

		return deliveryRepository.findById(deliveryId).map(delivery -> {
			return ResponseEntity.ok(deliveryAssembler.toModel(delivery));
		}).orElse(ResponseEntity.notFound().build());
	}

}
