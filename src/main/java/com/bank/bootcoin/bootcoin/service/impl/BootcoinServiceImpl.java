package com.bank.bootcoin.bootcoin.service.impl;

import org.springframework.stereotype.Service;

import com.bank.bootcoin.bootcoin.dto.UpdateBootcoinTrxRequest;
import com.bank.bootcoin.bootcoin.entity.Bootcoin;
import com.bank.bootcoin.bootcoin.repository.BootcoinRepository;
import com.bank.bootcoin.bootcoin.service.BootcoinService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class BootcoinServiceImpl implements BootcoinService{
	private  final BootcoinRepository bootcoinRepository;

    @Override
    public Flux<Bootcoin> getAllBootcoin() {
        return bootcoinRepository.findAll();
    }

    @Override
    public Mono<Bootcoin> getBootcoinById(String id) {
        return bootcoinRepository.findById(id);
    }
    
    @Override
	public Flux<Bootcoin> getBootcoinByDocumentNumber(Integer numDoc) {
		return bootcoinRepository.findByDocumentNumber(numDoc);
	}
    
    @Override
    public Mono<Bootcoin> createBootcoin(Bootcoin yan) {
    	yan.setBalance(0.0);
    	return bootcoinRepository.save(yan);  
    }

    @Override
    public Mono<Bootcoin> updateBootcoin(Bootcoin bootcoin) {
    	
        
        return bootcoinRepository.findById(bootcoin.getId())
                .flatMap( object ->{
                	object.setDocumentNumber(bootcoin.getDocumentNumber());
                	object.setMobile(bootcoin.getMobile());
                	object.setEmail(bootcoin.getEmail());
                	object.setBalance(bootcoin.getBalance());
                    return bootcoinRepository.save(object);
                 });
    }

    @Override
    public Mono<Bootcoin> deleteBootcoin(String id) {
        return bootcoinRepository.findById(id)
                .flatMap(existscreditRepository -> bootcoinRepository.delete(existscreditRepository)
                        .then(Mono.just(existscreditRepository)));
    }

	@Override
	public Mono<Bootcoin> updateBootcoinTrx(UpdateBootcoinTrxRequest trx) {
		return bootcoinRepository.findById(trx.getIdBootcoin())
                .flatMap( object ->{
                	object.setBalance(object.getBalance()+trx.getAmount()*trx.getType());
                    return bootcoinRepository.save(object);
                });
	}

	
}
