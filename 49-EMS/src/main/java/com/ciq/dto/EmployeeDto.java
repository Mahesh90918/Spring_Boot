package com.ciq.dto;

import java.util.List;

import com.ciq.entity.Department;
import com.ciq.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
	private Long eid;
	private String ename;
	private Double esal;
	private List<Long> pids;
	private Long did;
}
