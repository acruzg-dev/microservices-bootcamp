package com.nttdata.bootcamp.msproducts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.msproducts.models.documents.ProductBankAccount;
import com.nttdata.bootcamp.msproducts.services.ProductBankAccountService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products/banks-accounts")
public class ProductBankAccountController {

    private final ProductBankAccountService productBankAccountService;

    @GetMapping
    public Mono<ResponseEntity<Flux<ProductBankAccount>>> findAll(){
        return Mono.just(ResponseEntity.ok(this.productBankAccountService.findAll()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductBankAccount>> findById(@PathVariable String id){
        return this.productBankAccountService.findById(id)
            .map( find -> ResponseEntity.ok(find))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Mono<ResponseEntity<ProductBankAccount>> save(@RequestBody ProductBankAccount product){
        return this.productBankAccountService.save(product).map( save -> ResponseEntity.status(HttpStatus.CREATED).body(save));

    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ProductBankAccount>> update(@PathVariable String id,@RequestBody ProductBankAccount product){
        return this.productBankAccountService.findById(id)
            .flatMap(find -> {
                find.setCommission(product.getCommission());
                find.setMovementLimit(product.getMovementLimit());
                find.setTransactionDate(product.getTransactionDate());
                return this.productBankAccountService.save(find);
            }).map(save -> ResponseEntity.ok().body(save))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
