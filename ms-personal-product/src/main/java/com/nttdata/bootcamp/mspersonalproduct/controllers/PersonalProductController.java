package com.nttdata.bootcamp.mspersonalproduct.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;
import com.nttdata.bootcamp.mspersonalproduct.models.documents.Product;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalProductRequestDto;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalProductResponseDto;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalResponseDto;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.ProductResponseDto;
import com.nttdata.bootcamp.mspersonalproduct.services.CustomerPersonalService;
import com.nttdata.bootcamp.mspersonalproduct.services.PersonalProductService;
import com.nttdata.bootcamp.mspersonalproduct.services.ProductService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/personal-product")
@AllArgsConstructor
public class PersonalProductController { //actua como un handler

    
    private PersonalProductService personalProductService;

    private CustomerPersonalService customerPersonalService;

    private ProductService productService;
    

    

    // @GetMapping("/{numberDocument}")
    // public Mono<ResponseEntity<CustomerPersonal>> findByNumberDocument(@PathVariable String numberDocument){
    //     return personalProductService.findByNumberDocument(numberDocument).map(p -> ResponseEntity.ok(p));

    // }

    @PostMapping
    public Mono<ResponseEntity<PersonalProductRequestDto>> save(@RequestBody PersonalProductRequestDto personalProduct){
        PersonalProduct personalProductSaved = new PersonalProduct();
        // return this.customerPersonalService.findByNumberDocument(personalProduct.getPersonalNumberDocument())
        //         .flatMap(personal -> {
        //             personalProductSaved.setCustomerPersonalId(new ObjectId(personal.getId()));
        //             personalProduct.setCustomerPersonalId(personal.getId());
        //             return productService.findById(personalProduct.getProductId())
        //                 .flatMap(product-> {
        //                     personalProductSaved.setProductId(new ObjectId(personalProduct.getProductId()));
        //                     return personalProductService.save(personalProductSaved);
        //                 });
                    
        //         }).map(save-> ResponseEntity.status(HttpStatus.CREATED).body(personalProduct))
        //         .defaultIfEmpty(ResponseEntity.badRequest().build())
                // .onErrorResume(err-> ResponseEntity.badRequest().build());
    
        return this.customerPersonalService.findByNumberDocument(personalProduct.getPersonalNumberDocument())
            .flatMap(personal -> {
                personalProductSaved.setCustomerPersonalId(new ObjectId(personal.getId()));
                personalProduct.setCustomerPersonalId(personal.getId());
                return productService.findById(personalProduct.getProductId());
            })
            .flatMap(product-> {
                personalProductSaved.setProductId(new ObjectId(personalProduct.getProductId()));
                return personalProductService.save(personalProductSaved);
            })
            .map(save-> ResponseEntity.status(HttpStatus.CREATED).body(personalProduct))
            .defaultIfEmpty(ResponseEntity.badRequest().build())
            .onErrorResume(err -> Mono.just(ResponseEntity.badRequest().build()));
    }

    @GetMapping("/{numberDocument}")
    public Mono<ResponseEntity<PersonalResponseDto>> findByNumberDocument(@PathVariable String numberDocument){
        PersonalResponseDto responseDto = new PersonalResponseDto();
        List<PersonalProductResponseDto> personalProducts = new ArrayList<>();
        return this.customerPersonalService.findByNumberDocument(numberDocument)
                .flatMap(personal -> {
                    responseDto.setName(personal.getName());
                    responseDto.setLastname(personal.getLastname());
                    responseDto.setNumberDocument(personal.getNumberDocument());
                    responseDto.setAddress(personal.getAddress());
                    responseDto.setPhone(personal.getPhone());
                    return this.personalProductService.findByCustomerPersonalId(personal.getId());
                })
                .flatMap(personalProduct -> {
                    return this.productService.findById(personalProduct.getProductId().toString()).map(product-> {
                        PersonalProductResponseDto pp = new PersonalProductResponseDto();
                        pp.setBalance(personalProduct.getBalance());
                        pp.setNumberAccount(personalProduct.getNumberAccount());
                        pp.setCreateAt(personalProduct.getCreateAt());
                        ProductResponseDto p = new ProductResponseDto();
                        p.setName(product.getName());
                        p.setCommission(product.getCommission());
                        p.setMovementLimit(product.getMovementLimit());
                        p.setCreatedAt(product.getCreatedAt());
                        pp.setProduct(p);
                        personalProducts.add(pp);
                        responseDto.setPersonalProducts(personalProducts);
                        return product;
                    });
                })
                
                .map(response -> ResponseEntity.ok(responseDto))
                .defaultIfEmpty(ResponseEntity.notFound().build());
                
                

    }

}
