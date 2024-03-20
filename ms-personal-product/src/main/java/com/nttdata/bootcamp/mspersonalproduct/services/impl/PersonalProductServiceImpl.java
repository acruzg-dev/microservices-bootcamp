package com.nttdata.bootcamp.mspersonalproduct.services.impl;


import java.util.Date;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalProductRequestDto;
import com.nttdata.bootcamp.mspersonalproduct.repositories.PersonalProductRepository;

import com.nttdata.bootcamp.mspersonalproduct.services.PersonalProductService;


import reactor.core.publisher.Mono;


@Service
public class PersonalProductServiceImpl implements PersonalProductService{
    @Autowired
    private PersonalProductRepository personalProductRepository;

    @Override
    public Mono<PersonalProduct> save(PersonalProduct personalProduct) {
        int min=100;
        int max=999;
        personalProduct.setBalance(0.0);
        personalProduct.setCreateAt(new Date());
        personalProduct.setNumberAccount(new Random().nextInt(max-min+1)+min+"-"+new Random().nextInt(max-min+1)+min+"-"+new Random().nextInt(max-min+1)+min);
        personalProduct.setBalance(0.0);
        return this.personalProductRepository.save(personalProduct);
    }

    @Override
    public Mono<PersonalProduct> findByCustomerPersonalId(String customerPersonalId) {
        return this.personalProductRepository.findByCustomerPersonalId(new ObjectId(customerPersonalId));
    }

    

    

    

    
    
}
