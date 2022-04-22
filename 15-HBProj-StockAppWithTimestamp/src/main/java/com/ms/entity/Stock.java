package com.ms.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@Table(name="STOCK_INFO")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Stock {
	private Integer stockId;
	@NonNull
	private String stockName;
	@NonNull
	private Double stockPrice;
	@NonNull
	private String exchange;
	private Timestamp lastUpdate;

}
