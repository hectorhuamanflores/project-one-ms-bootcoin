package com.bank.bootcoin.bootcoin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bootcoin.bootcoin.dto.BootcoinByIdRequest;
import com.bank.bootcoin.bootcoin.dto.BootcoinByNumDocRequest;
import com.bank.bootcoin.bootcoin.dto.UpdateBootcoinTrxRequest;
import com.bank.bootcoin.bootcoin.entity.Bootcoin;
import com.bank.bootcoin.bootcoin.service.BootcoinService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bootcoin")
public class BootcoinController {

	private final BootcoinService bootcoinService;
	
    @GetMapping
    public Flux<Bootcoin>getAllBootcoin() {
        Flux<Bootcoin> list=this.bootcoinService.getAllBootcoin();
        return list; 
    }
    
    @PostMapping("/idBootcoin")
    public Mono<Bootcoin> getBootcoinById(@RequestBody BootcoinByIdRequest bootcoinByIdRequest){
        var bootcoin=this.bootcoinService.getBootcoinById(bootcoinByIdRequest.getIdBootcoin());
        return bootcoin;
    }
    
    @PostMapping("/numberDocument")
    public Flux<Bootcoin> getBootcoinByNumDoc(@RequestBody BootcoinByNumDocRequest bootcoinByNumDocRequest){
    	Flux<Bootcoin> list=this.bootcoinService.getBootcoinByDocumentNumber(bootcoinByNumDocRequest.getDocumentNumber());
        return  list;
    
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Bootcoin> create(@RequestBody Bootcoin bootcoin){
        return bootcoinService.createBootcoin(bootcoin);
    }

    @PutMapping("/updateYanki")
    public Mono<Bootcoin> updateYanki(@RequestBody Bootcoin bootcoin){
        return this.bootcoinService.updateBootcoin(bootcoin);         
    }

    @DeleteMapping("/{id}")
    public Mono<Bootcoin> deleteYankiById(@PathVariable String id){
        return bootcoinService.deleteBootcoin(id);
                
    }
    
    @PutMapping("/updateBootcoinTrx")
    public Mono<Bootcoin> updateBootcoinTrx(@RequestBody UpdateBootcoinTrxRequest trx){

        return bootcoinService.updateBootcoinTrx(trx);
    }
    
}
