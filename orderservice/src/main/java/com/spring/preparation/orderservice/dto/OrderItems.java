package com.spring.preparation.orderservice.dto;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDER_ITEMS_TBL")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID.AUTO)
	@Column(name = "GUID", unique = true)
	private String guid;
	
	@Column(name = "ITEM")
	private String item;
	
	@Column(name = "QTY")
	private int qty;

	
}
