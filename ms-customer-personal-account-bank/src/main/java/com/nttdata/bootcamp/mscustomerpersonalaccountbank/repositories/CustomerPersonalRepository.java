package com.nttdata.bootcamp.mscustomerpersonalaccountbank.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.documents.CustomerPersonal;

import reactor.core.publisher.Mono;

@FeignClient(name = "ms-customers")
public interface CustomerPersonalRepository {

    @GetMapping("/api/customers/personal/number-document/{numberDocument}")
    public Mono<CustomerPersonal> findByNumberDocument(@PathVariable String numberDocument);

    // public Mono<CustomerPersonal> save()
}
