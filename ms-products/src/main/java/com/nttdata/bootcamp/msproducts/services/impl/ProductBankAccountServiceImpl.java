package com.nttdata.bootcamp.msproducts.services.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.msproducts.models.documents.ProductBankAccount;
import com.nttdata.bootcamp.msproducts.repositories.ProductBankAccountRepository;
import com.nttdata.bootcamp.msproducts.services.ProductBankAccountService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ProductBankAccountServiceImpl implements ProductBankAccountService{

    private final ProductBankAccountRepository productBankAccountRepository;
    @Override
    public Flux<ProductBankAccount> findAll() {
        return this.productBankAccountRepository.findAll();
    }

    @Override
    public Mono<ProductBankAccount> findById(String id) {
        return this.productBankAccountRepository.findById(id);
    }

    @Override
    public Mono<ProductBankAccount> save(ProductBankAccount product) {
        if(product.getCreatedAt()==null){
            product.setCreatedAt(new Date());
        }
        return this.productBankAccountRepository.save(product);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productBankAccountRepository.deleteById(id);
    }

    
}
