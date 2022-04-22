package com.ms.in.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Employee extends Person {
	private String desg;
	private String compony;
	private Double salary;
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", compony=" + compony + ", salary=" + salary + "]";
	}

}
