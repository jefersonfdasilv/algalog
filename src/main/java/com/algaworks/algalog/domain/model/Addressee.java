package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Addressee {

	@NotBlank
	@Column(name = "addressee_name")
	private String name;

	@NotBlank
	@Column(name = "addressee_street_address")
	private String street;
	
	@NotBlank
	@Column(name = "addressee_city")
	private String city;
	
	@NotBlank
	@Column(name = "addressee_province")
	private String province;

	@NotBlank
	@Column(name = "addressee_postal_code")
	private String code;

	@NotBlank
	@Column(name = "addressee_country")
	private String country;

}