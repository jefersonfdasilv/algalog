package com.algaworks.algalog.api.model.response;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceModelResponse {
	
	private Long id;
	private String description;
	private OffsetDateTime createdAt;
}
