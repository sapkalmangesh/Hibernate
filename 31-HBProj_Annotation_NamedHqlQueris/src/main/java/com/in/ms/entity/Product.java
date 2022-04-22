package com.in.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PRODUCT")
@NamedQuery(name="GET_PRODUCT_RECORD_BY_PRICE_RANGE", 
            query="from Product where price>=:min and price<=:max")
@NamedQuery(name="INCRESE_PRODUCT_BY_PRICE_RANGE", 
			query="update Product set price=price+:newValue where price>=:range")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="PID")
	private Integer pid;
	
	@Column(name="PNAME")
	private String pname;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="QTY")
	private Integer qty;

}
