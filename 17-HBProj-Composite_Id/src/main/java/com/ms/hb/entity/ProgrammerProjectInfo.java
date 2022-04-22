package com.ms.hb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammerProjectInfo {
	private PrgmrProjId id;
	private String prgmrName;
	private Double salary;
	private String projName;
	private Double budget;
}
