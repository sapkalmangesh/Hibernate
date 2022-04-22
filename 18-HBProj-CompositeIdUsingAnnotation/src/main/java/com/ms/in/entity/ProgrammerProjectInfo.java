package com.ms.in.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PROGRAMMER_PROJECT_INFO")
public class ProgrammerProjectInfo {
	@EmbeddedId
	private PrgmrProjId id;
	
	@Column(name="DEVLOPER_NAME")
	private String prgmrName;
	
	@Column(name="SALARY")
	private Double salary;
	
	@Column(name="PROJ_NAME")
	private String projName;
	
	@Column(name="BUDGET")
	private Double budget;

}
