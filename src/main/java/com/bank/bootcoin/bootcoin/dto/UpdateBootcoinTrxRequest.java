package com.bank.bootcoin.bootcoin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBootcoinTrxRequest {
  
	private String   idBootcoin; // id bootcoin
	private Integer  type;       // type=1=añade   type=-1=quita  bootcoin
	private Double   amount;     // monto de la transaccion de bootcoin
}
