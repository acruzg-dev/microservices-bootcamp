package com.nttdata.bootcamp.mstransactions.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.mstransactions.models.documents.PersonalProduct;
import com.nttdata.bootcamp.mstransactions.services.PersonalProductService;

import reactor.core.publisher.Mono;

@Service
public class PersonalProductServiceImpl implements PersonalProductService{

    @Autowired
    @Qualifier("personal-product")
    private WebClient.Builder clientPersonalProduct;
    
    

    @Override
    public Mono<PersonalProduct> findByNumberAccount(String numberAccount) {
        return clientPersonalProduct
            .build()
            .get().uri("/number-account/{numberAccount}",Map.of("numberAccount",numberAccount))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(PersonalProduct.class);
    }
}
