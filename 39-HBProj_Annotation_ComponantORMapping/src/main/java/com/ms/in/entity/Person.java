package com.ms.in.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HB_COMP_PERSON")
public class Person implements Serializable {
	@Id
	@GeneratedValue
	@Column
	private Integer pid;
	
	@Column
	private String pname;
	
	@Column
	private String addr;
	
	@Embedded
	private JobDetailes details;

}
