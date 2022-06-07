package com.bank.bootcoin.bootcoin.service;

import com.bank.bootcoin.bootcoin.dto.UpdateBootcoinTrxRequest;
import com.bank.bootcoin.bootcoin.entity.Bootcoin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinService {

    public Flux<Bootcoin> getAllBootcoin();
    public Mono<Bootcoin> getBootcoinById(String id);
    public Mono<Bootcoin> createBootcoin(Bootcoin bootcoin);
    public Mono<Bootcoin> updateBootcoin(Bootcoin bootcoin);
    public Mono<Bootcoin> deleteBootcoin(String id);
    public Flux<Bootcoin> getBootcoinByDocumentNumber(Integer numdoc);
    
    public Mono<Bootcoin> updateBootcoinTrx(UpdateBootcoinTrxRequest trx);
    

}
