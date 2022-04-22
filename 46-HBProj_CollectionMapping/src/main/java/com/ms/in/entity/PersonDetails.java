package com.ms.in.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonDetails {
	private Integer pid;
	private String pname;
	private String addr;
	private List<String> nickname;
	private List<String> friends;
	private Set<Long> contactNo;
	private Map<String,Long> idDetails;
}
