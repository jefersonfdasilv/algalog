package com.algaworks.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.request.DeliveryModelRequest;
import com.algaworks.algalog.api.model.response.DeliveryModelResponse;
import com.algaworks.algalog.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

	private ModelMapper mapper;

	public DeliveryModelResponse toModel(Delivery delivery) {
		return mapper.map(delivery, DeliveryModelResponse.class);
	}

	public List<DeliveryModelResponse> toCollectionModel(List<Delivery> deliveries) {
		return deliveries.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryModelRequest deliveryModelRequest) {
		return mapper.map(deliveryModelRequest, Delivery.class);
	}

}
