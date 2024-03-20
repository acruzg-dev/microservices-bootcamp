package com.nttdata.bootcamp.mscustomerpersonalaccountbank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.dtos.CustomerPersonalDto;
import com.nttdata.bootcamp.mscustomerpersonalaccountbank.services.CustomerPersonalProductAccountService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customer/personal/bank-account")
@AllArgsConstructor
public class CustomerPersonalBankAccountController {

    private final CustomerPersonalProductAccountService customerPersonalProductAccountService;

    @GetMapping("/personal-number-document/{numberDocument}")
    public Mono<ResponseEntity<CustomerPersonalDto>> findByNumberDocument(@PathVariable String numberDocument){
        return this.customerPersonalProductAccountService
            .findByNumberDocument(numberDocument)
            .map(find -> ResponseEntity.ok(find))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
}
