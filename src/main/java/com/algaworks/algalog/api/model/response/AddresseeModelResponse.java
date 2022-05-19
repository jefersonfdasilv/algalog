package com.algaworks.algalog.api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddresseeModelResponse {

	private String name;
	private String street;
	private String city;
	private String province;
	private String code;
	private String country;

}
