package com.nttdata.bootcamp.mstransactions.services;

import com.nttdata.bootcamp.mstransactions.models.documents.PersonalProduct;

import reactor.core.publisher.Mono;

public interface PersonalProductService {

    public Mono<PersonalProduct> findByNumberAccount(String numberAccount);
}
