package com.ms.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PRODUCT")
@NamedNativeQuery(name="GET_RECORD_BY_PRICE_RANGE",
                  query="SELECT * FROM PRODUCT WHERE PRICE>=? AND PRICE<=?",
                  resultClass =Product.class)
@NamedNativeQuery(name="UPDATE_PRICE_BY_PRODUCT", 
			      query="UPDATE PRODUCT SET PRICE=PRICE+? WHERE PNAME=?")
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
