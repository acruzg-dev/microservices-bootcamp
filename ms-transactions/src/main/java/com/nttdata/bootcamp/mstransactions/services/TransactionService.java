package com.nttdata.bootcamp.mstransactions.services;

import com.nttdata.bootcamp.mstransactions.models.documents.Transaction;

import reactor.core.publisher.Mono;

public interface TransactionService {

    public Mono<Transaction> payTo(String numberAccount);

    public Mono<Transaction> withdrawTo(String numberAccount);
}
