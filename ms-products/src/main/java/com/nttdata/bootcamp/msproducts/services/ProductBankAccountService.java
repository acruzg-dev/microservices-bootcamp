package com.nttdata.bootcamp.msproducts.services;

import com.nttdata.bootcamp.msproducts.models.documents.ProductBankAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductBankAccountService {

    public Flux<ProductBankAccount> findAll();

    public Mono<ProductBankAccount> findById(String id);

    public Mono<ProductBankAccount> save(ProductBankAccount product);

    public Mono<Void> deleteById(String id);
}
