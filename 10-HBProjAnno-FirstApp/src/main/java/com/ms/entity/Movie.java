package com.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MOVIE_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@Column(name="MID")
	private Integer mid;
	
	@Column(name="MNAME")
	private String mname;
	
	@Column(name="ACTOR")
	private String actor;
	
	@Column(name="ACTRESS")
	private String actress;
	
	@Column(name="BUDGET")
	private Float budget;
	

}
