package com.nttdata.bootcamp.mspersonalproduct.models.dtos;


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
