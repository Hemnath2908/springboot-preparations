package com.spring.preparation.orderservice.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_TBL")
public class OrderServiceDTO {
	
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private int orderId;
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
	//@Column(name = "ITEM")
	private List<OrderItems> orderItems;
	
	@Column(name = "PRICE")
	private  int price;
	
	@Column(name = "STATUS")
	private String status;
	

}
