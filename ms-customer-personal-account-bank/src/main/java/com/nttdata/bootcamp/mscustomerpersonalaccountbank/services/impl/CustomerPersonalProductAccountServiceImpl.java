package com.nttdata.bootcamp.mscustomerpersonalaccountbank.services.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.documents.PersonalBankAccount;
import com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.dtos.CustomerPersonalDto;
import com.nttdata.bootcamp.mscustomerpersonalaccountbank.repositories.CustomerPersonalRepository;
import com.nttdata.bootcamp.mscustomerpersonalaccountbank.services.CustomerPersonalProductAccountService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class CustomerPersonalProductAccountServiceImpl implements CustomerPersonalProductAccountService{

    private final CustomerPersonalRepository customerPersonalRepository;

    private RestTemplate clientRest;
    @Override
    public Mono<PersonalBankAccount> save(PersonalBankAccount personalBankAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Mono<CustomerPersonalDto> findByNumberDocument(String numberDocument) {
        
        System.out.println(clientRest.getForObject("localhost:8081/api/customers/personal/number-document/{numberDocument}", CustomerPersonalDto.class, Map.of("numberDocument",numberDocument)));
        return this.customerPersonalRepository.findByNumberDocument(numberDocument).map(find -> {
            return CustomerPersonalDto.builder()
                .name(find.getName())
                .address(find.getAddress())
                .lastname(find.getLastname())
                .numberDocument(find.getNumberDocument())
                .phone(find.getPhone())
                .build();
            
        });
        
        
    }

    

    
}
