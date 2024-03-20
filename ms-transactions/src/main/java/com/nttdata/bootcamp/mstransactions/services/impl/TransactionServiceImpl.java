package com.nttdata.bootcamp.mstransactions.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.mstransactions.models.documents.Transaction;
import com.nttdata.bootcamp.mstransactions.services.TransactionService;

import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    @Qualifier("personal-product")
    private WebClient.Builder clientPersonalProduct;

    @Override
    public Mono<Transaction> payTo(String numberAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payTo'");
    }

    @Override
    public Mono<Transaction> withdrawTo(String numberAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdrawTo'");
    }

}
