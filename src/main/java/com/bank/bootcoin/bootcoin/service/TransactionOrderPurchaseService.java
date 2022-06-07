package com.bank.bootcoin.bootcoin.service;

import com.bank.bootcoin.bootcoin.entity.TransactionOrderPurchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionOrderPurchaseService {
   
	public Flux<TransactionOrderPurchase> getAllTransactionOrderPurchase();
    public Mono<TransactionOrderPurchase> getTransactionOrderPurchaseById(String id);
    public Mono<TransactionOrderPurchase> transactionOrderPurchaseById(String id);
    public Mono<TransactionOrderPurchase> createTransactionOrderPurchase(TransactionOrderPurchase bootcoin);
    public Mono<TransactionOrderPurchase> updateTransactionOrderPurchase(TransactionOrderPurchase bootcoin);
    public Mono<TransactionOrderPurchase> deleteTransactionOrderPurchase(String id);
}
