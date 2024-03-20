package com.nttdata.bootcamp.mscustomerpersonalaccountbank.repositories;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-products")
public interface ProductAccountBankRepository {

}
