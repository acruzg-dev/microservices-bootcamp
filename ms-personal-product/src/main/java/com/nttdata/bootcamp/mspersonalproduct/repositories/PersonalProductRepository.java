package com.nttdata.bootcamp.mspersonalproduct.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;

import reactor.core.publisher.Mono;

public interface PersonalProductRepository extends ReactiveMongoRepository<PersonalProduct,String>{

    public Mono<PersonalProduct> findByCustomerPersonalId(ObjectId customerPersonalId);
}
