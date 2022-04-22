package com.ms.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue
	@Column
	private Integer pid;
	
	@Column
	private String pname;
	
	@Column
	private Double price;
	
	@Column
	private Integer qty;

}
