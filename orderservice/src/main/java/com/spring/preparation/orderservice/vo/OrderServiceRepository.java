package com.spring.preparation.orderservice.vo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.preparation.orderservice.dto.OrderServiceDTO;

@Repository
public interface OrderServiceRepository extends  JpaRepository<OrderServiceDTO, Serializable>{

}
