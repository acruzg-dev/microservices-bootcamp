package com.nttdata.bootcamp.mspersonalproduct.models.dtos;


import org.springframework.data.annotation.Id;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.CustomerPersonal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalProductRequestDto {

    // private CustomerPersonal customerPersonal;

    private String customerPersonalId;
    private String productId;
    private String personalNumberDocument;


}
