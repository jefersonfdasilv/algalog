package com.algaworks.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.response.OccurrenceModelResponse;
import com.algaworks.algalog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {
	private ModelMapper mapper;
	
	public  OccurrenceModelResponse toModel(Occurrence occurrence) {
		return mapper.map(occurrence, OccurrenceModelResponse.class);
	}
	
	public List<OccurrenceModelResponse> toCollectionModel(List<Occurrence> occurrences) {
		return occurrences.stream().map(this::toModel).collect(Collectors.toList());
	}
}
