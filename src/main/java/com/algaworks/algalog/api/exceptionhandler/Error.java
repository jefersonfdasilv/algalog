package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class Error {
	
	private String title;
	private Integer status;
	private LocalDateTime date;
	private List<Field> fields;
	
	public Error() {
		date = LocalDateTime.now();
		fields = new ArrayList<>();
	}
	
	public void addFild(String name, String message){
		fields.add(new Field(name, message));
	}
	
	@AllArgsConstructor
	@Getter
	public static class Field {
		private String name;
		private String message;
	}
}
