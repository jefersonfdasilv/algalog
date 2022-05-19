package com.algaworks.algalog.api.model.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.DeliveryStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryModelResponse {
	private Long id;
	private ClientSummaryModelResponse client;
	private AddresseeModelResponse addressee;
	private BigDecimal rate;
	private DeliveryStatus status;
	private OffsetDateTime orderDate;
	private OffsetDateTime deliveryDate;
}
