package com.mahesh.queries;

public interface EmployeeQueries {
	String FIND_BY_ID = "SELECT * FROM EMPOLYEE WHERE ID=?";
	String DELETE_BY_ID = "DELETE FROM EMPOLYEE WHERE ID=?";
	String INSERT_QUERY = "INSERT INTO EMPOLYEE VALUES(?,?,?,?)";
	String UPDATE = "UPDATE EMPOLYEE SET NAME=?,SALARY=?,EMAIL=? WHERE ID=?";
	String FIND_ALL = "SELECT * FROM EMPOLYEE";
}
