package com.nttdata.bootcamp.mspersonalproduct.services;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalProductRequestDto;

import reactor.core.publisher.Mono;

public interface PersonalProductService {

    public Mono<PersonalProduct> save(PersonalProduct personalProduct);
}
