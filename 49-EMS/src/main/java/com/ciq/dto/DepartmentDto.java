package com.ciq.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
	private Long did;
	@NotEmpty(message = "Dname shoud not be empty")
	private String dname;
	@NotEmpty(message = "Dlocation shoud not be empty")
	private String dlocation;
}
