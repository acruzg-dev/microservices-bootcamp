package com.nttdata.bootcamp.msproducts.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.msproducts.models.documents.ProductBankAccount;

public interface ProductBankAccountRepository extends ReactiveMongoRepository<ProductBankAccount, String>{


}
