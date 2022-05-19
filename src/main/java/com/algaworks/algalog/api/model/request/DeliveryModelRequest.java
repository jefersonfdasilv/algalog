package com.algaworks.algalog.api.model.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryModelRequest {
	
	@Valid
	@NotNull
	private ClientIdRequest client;
	
	@Valid
	@NotNull
	private AddresseeModelRquest addressee;
	
	@NotNull
	private BigDecimal rate;
}
