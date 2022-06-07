package com.bank.bootcoin.bootcoin.service.impl;

import org.springframework.stereotype.Service;

import com.bank.bootcoin.bootcoin.entity.Bootcoin;
import com.bank.bootcoin.bootcoin.entity.TransactionOrderPurchase;
import com.bank.bootcoin.bootcoin.repository.TransactionOrderPurchaseRepository;
import com.bank.bootcoin.bootcoin.service.TransactionOrderPurchaseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionOrderPurchaseServiceImpl implements TransactionOrderPurchaseService{
	
	
	private  final TransactionOrderPurchaseRepository transactionOrderPurchaseRepository;
	@Override
	public Flux<TransactionOrderPurchase> getAllTransactionOrderPurchase() {
		// TODO Auto-generated method stub
		return transactionOrderPurchaseRepository.findAll();
	}

	@Override
	public Mono<TransactionOrderPurchase> getTransactionOrderPurchaseById(String id) {
		// TODO Auto-generated method stub
		return transactionOrderPurchaseRepository.findById(id);
	}

	@Override
	public Mono<TransactionOrderPurchase> createTransactionOrderPurchase(TransactionOrderPurchase transactionOrderPurchase) {
		
		transactionOrderPurchase.setStatus("proceso");
		return transactionOrderPurchaseRepository.save(transactionOrderPurchase);
	}

	@Override
	public Mono<TransactionOrderPurchase> updateTransactionOrderPurchase(TransactionOrderPurchase transactionOrderPurchase) {
		return transactionOrderPurchaseRepository.findById(transactionOrderPurchase.getId())
                .flatMap( object ->{
                	object.setAmount(transactionOrderPurchase.getAmount());
                	object.setType(transactionOrderPurchase.getType());
                	object.setPaymentMethod(transactionOrderPurchase.getPaymentMethod());
                	object.setAccountYanki(transactionOrderPurchase.getAccountYanki());
                	object.setIdBuyer(transactionOrderPurchase.getIdBuyer());
                	object.setIdSeller(transactionOrderPurchase.getIdSeller());
                	object.setStatus(transactionOrderPurchase.getStatus());
                    return transactionOrderPurchaseRepository.save(object);
                 });
	}

	@Override
	public Mono<TransactionOrderPurchase> deleteTransactionOrderPurchase(String id) {
		return transactionOrderPurchaseRepository.findById(id)
                .flatMap(existscreditRepository -> transactionOrderPurchaseRepository.delete(existscreditRepository)
                        .then(Mono.just(existscreditRepository)));
	}

	@Override
	public Mono<TransactionOrderPurchase> transactionOrderPurchaseById(String id) {
		// TODO Auto-generated method stub
		return transactionOrderPurchaseRepository.findById(id);
	}

}
