package com.nttdata.bootcamp.mscustomerpersonalaccountbank.services;


import com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.documents.PersonalBankAccount;
import com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.dtos.CustomerPersonalDto;

import reactor.core.publisher.Mono;

public interface CustomerPersonalProductAccountService {

    public Mono<PersonalBankAccount> save(PersonalBankAccount personalBankAccount);

    public Mono<CustomerPersonalDto> findByNumberDocument(String numberDocument);
}
