package com.algaworks.algalog.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Occurrence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Delivery delivery;
	
	private String description;
	
	private OffsetDateTime createdAt;
	
	public Occurrence() {
		createdAt = OffsetDateTime.now();
	}
	

}
