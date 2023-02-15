package com.mahesh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(unique = true)
	@NotEmpty(message = "UserName should Not be Null")
	@Size(min = 3, max = 10,message = "user name should have at least 3 characters")
	private String userName;
	@NotEmpty(message = "password should Not be Null")
	private String password;
	@NotEmpty(message = "FirstName should Not be Null")
	private String firstName;
	@NotEmpty(message = "lastName should Not be Null")
	private String lastName;

	@Column(unique = true)
	@NotEmpty(message = "email should Not be Null")
	private String email;
	@NotEmpty(message = "mobile should Not be Null")
	private String mobile;
	@NotEmpty(message = "dept should Not be Null")
	private String department;
	private Boolean isActive;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })

	@JsonIgnoreProperties("users")
	private List<Role> roles;

}
