package com.nttdata.bootcamp.mspersonalproduct.controllers;


import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalProductRequestDto;
import com.nttdata.bootcamp.mspersonalproduct.models.dtos.PersonalProductResponseDto;
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
        return this.customerPersonalService.findByNumberDocument(personalProduct.getPersonalNumberDocument())
                .flatMap(personal -> {
                    personalProductSaved.setCustomerPersonalId(new ObjectId(personal.getId()));
                    System.out.println(")))))))))))"+personal.toString());
                    return personalProductService.save(personalProductSaved);
                }).map(save-> ResponseEntity.status(HttpStatus.CREATED).body(personalProduct));
        // return this.customerPersonalService.findByNumberDocument(personalProduct.getPersonalNumberDocument())
        //         .flatMap(personal -> {
        //             personalProduct.setCustomerPersonalId(personal.getId());
        //             return this.productService.findById(personalProduct.getProductId())
        //                 .flatMap(product-> {
        //                     personalProduct.setProductId(product.getId());
        //                     return this.personalProductService.save(personalProduct);
        //                 }).defaultIfEmpty(ResponseEntity.badRequest().build());
        //         }).map( res -> ResponseEntity.status(HttpStatus.CREATED).body(personalProduct));
    }

}
