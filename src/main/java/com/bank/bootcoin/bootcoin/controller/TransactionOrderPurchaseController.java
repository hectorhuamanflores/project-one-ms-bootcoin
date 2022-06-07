package com.bank.bootcoin.bootcoin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bootcoin.bootcoin.dto.TransactionOrderPurchaseByIdRequest;
import com.bank.bootcoin.bootcoin.entity.TransactionOrderPurchase;
import com.bank.bootcoin.bootcoin.service.TransactionOrderPurchaseService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderPurchase")
public class TransactionOrderPurchaseController {
    
private final TransactionOrderPurchaseService transactionOrderPurchaseService;
	
    @GetMapping
    public Flux<TransactionOrderPurchase>getAllTransactionOrderPurchase() {
        Flux<TransactionOrderPurchase> list=this.transactionOrderPurchaseService.getAllTransactionOrderPurchase();
        return list; 
    }
    
    @PostMapping("/idTransactionOrderPurchase")
    public Mono<TransactionOrderPurchase> getTransactionOrderPurchaseById(@RequestBody TransactionOrderPurchaseByIdRequest bootcoinByIdRequest){
        var bootcoin=this.transactionOrderPurchaseService.getTransactionOrderPurchaseById(bootcoinByIdRequest.getIdTransactionOrderPurchase());
        return bootcoin;
    }
    
    @GetMapping("/{id}")
    public Mono<TransactionOrderPurchase> transactionOrderPurchaseById(@PathVariable String id){
        return transactionOrderPurchaseService.transactionOrderPurchaseById(id);
                
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TransactionOrderPurchase> create(@RequestBody TransactionOrderPurchase bootcoin){
        return transactionOrderPurchaseService.createTransactionOrderPurchase(bootcoin);
    }

    @PutMapping("/updateTransactionOrderPurchase")
    public Mono<TransactionOrderPurchase> updateTransactionOrderPurchase(@RequestBody TransactionOrderPurchase bootcoin){
        return this.transactionOrderPurchaseService.updateTransactionOrderPurchase(bootcoin);         
    }

    @DeleteMapping("/{id}")
    public Mono<TransactionOrderPurchase> deleteTransactionOrderPurchaseById(@PathVariable String id){
        return transactionOrderPurchaseService.deleteTransactionOrderPurchase(id);
                
    }
}
