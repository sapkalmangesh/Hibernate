package com.ms.in.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private Integer pid;
	private String pname;
	private String addr;
	private JobDetailes details;

}
