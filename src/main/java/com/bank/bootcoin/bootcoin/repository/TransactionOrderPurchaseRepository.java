package com.bank.bootcoin.bootcoin.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.bootcoin.bootcoin.entity.TransactionOrderPurchase;

@Repository
public interface TransactionOrderPurchaseRepository extends ReactiveCrudRepository<TransactionOrderPurchase,String> {

}
