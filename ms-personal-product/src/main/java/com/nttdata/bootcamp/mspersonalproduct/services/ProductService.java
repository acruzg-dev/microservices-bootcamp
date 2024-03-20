package com.nttdata.bootcamp.mspersonalproduct.services;

import org.bson.types.ObjectId;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.Product;

import reactor.core.publisher.Mono;

public interface ProductService {

    public Mono<Product> findById(String id);
    
}
