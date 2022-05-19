package com.algaworks.algalog.api.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddresseeModelRquest {

	@NotNull
	@Size(min = 3, max = 60)
	private String name;
	
	@NotBlank
	@Size(min = 3, max = 255)
	private String street;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String city;
	
	@NotBlank
	@Size(min = 3, max = 60)
	private String province;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String code;
	
	@NotBlank
	@Size(min = 3, max = 60)
	private String country;

}
