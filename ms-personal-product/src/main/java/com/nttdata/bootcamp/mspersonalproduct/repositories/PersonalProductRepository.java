package com.nttdata.bootcamp.mspersonalproduct.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;

public interface PersonalProductRepository extends ReactiveMongoRepository<PersonalProduct,String>{

}
