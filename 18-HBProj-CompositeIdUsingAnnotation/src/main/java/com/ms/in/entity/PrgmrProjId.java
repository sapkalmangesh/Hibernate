package com.ms.in.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PrgmrProjId implements Serializable {
	public PrgmrProjId(int i, int j) {
		// TODO Auto-generated constructor stub
	}
	@Column(name="PRGMRID")
	private Integer prgmrId;
	@Column(name="PROJID")
	private Integer projId;

}
