package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.algalog.domain.validation.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	@NotNull
	private Client client;
	
	@NotNull
	private BigDecimal rate;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = Access.READ_ONLY)
	private DeliveryStatus status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime orderDate;
	
	@Embedded
	@Valid
	@NotNull
	private Addressee addressee;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime deliveryDate;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> occurrences;
	
	public Delivery() {
		status = DeliveryStatus.PENDING;
		orderDate = OffsetDateTime.now();
		occurrences = new ArrayList<Occurrence>();
	}

	public Occurrence addOccurrence(String description) {
		
		var occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setDelivery(this);
		
		occurrences.add(occurrence);

		return occurrence;
		
	}

}