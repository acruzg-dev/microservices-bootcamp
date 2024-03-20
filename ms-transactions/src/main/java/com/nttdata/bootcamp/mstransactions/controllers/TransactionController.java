package com.nttdata.bootcamp.mstransactions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mstransactions.dto.request.TransactionRequestDto;
import com.nttdata.bootcamp.mstransactions.models.documents.PersonalProduct;
import com.nttdata.bootcamp.mstransactions.services.PersonalProductService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private PersonalProductService personalProductService;

    @PostMapping("/pay-to")
    public Mono<ResponseEntity<PersonalProduct>> PayTo(@RequestBody TransactionRequestDto dto){

        return this.personalProductService.findByNumberAccount(dto.getNumberAccount())
                .map(personalProduct -> {
                    return ResponseEntity.ok(personalProduct);
                });
    }
}
