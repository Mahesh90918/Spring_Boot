package com.mahesh.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table
public class Room {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long roomId;
		private String roomName;
		@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JoinColumn(name = "labId")
		private Lab lab;
		@OneToMany(mappedBy = "room")
		private List<Asset> assets;
}
