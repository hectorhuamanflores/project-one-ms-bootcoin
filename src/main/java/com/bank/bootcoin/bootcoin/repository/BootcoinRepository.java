package com.bank.bootcoin.bootcoin.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.bootcoin.bootcoin.entity.Bootcoin;

import reactor.core.publisher.Flux;

@Repository
public interface BootcoinRepository  extends ReactiveCrudRepository<Bootcoin,String> {
    
	Flux<Bootcoin> findByDocumentNumber(Integer documentNumber);
	
}
