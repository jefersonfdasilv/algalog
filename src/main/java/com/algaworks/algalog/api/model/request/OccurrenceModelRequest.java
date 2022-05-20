package com.algaworks.algalog.api.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceModelRequest {
	
	@NotBlank
	@NotNull
	private String description;
}
