package com.bank.bootcoin.bootcoin.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(value = "BOOTCOIN-ORDER-PURCHASE")
public class TransactionOrderPurchase {
	  
	  @Id
	  private String id;
	  private Double amount;         // cantidad solicitada de compra de bootcoin
	  private String type;           // bootcoin
	  private String paymentMethod;  // transferencia - yanki
	  private String accountYanki;   // numero de cuenta o telefono vendedor
	  private String idBuyer;        // id bootcoin del comprador
	  private String idSeller;       // id bootcoin del vendedor
	  private String status;         // estado de la solicitud:   proceso - terminado
}
