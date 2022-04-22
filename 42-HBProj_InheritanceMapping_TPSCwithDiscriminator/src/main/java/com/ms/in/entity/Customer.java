package com.ms.in.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	Double billAmt;
	Integer billNo;
	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", billNo=" + billNo + "]";
	}
	

}
