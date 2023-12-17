package com.spring.preparation.payment.vo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.preparation.payment.dto.PaymentDTO;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDTO, Serializable> {

}
