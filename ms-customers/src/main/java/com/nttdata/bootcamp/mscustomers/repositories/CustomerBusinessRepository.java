package com.nttdata.bootcamp.mscustomers.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.mscustomers.models.documents.CustomerBusiness;

public interface CustomerBusinessRepository extends ReactiveMongoRepository<CustomerBusiness,String>{

}
