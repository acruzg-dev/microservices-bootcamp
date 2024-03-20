package com.nttdata.bootcamp.mspersonalproduct.models.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalProductResponseDto {

    //data de la persona
    // private String id;
    private String numberAccount;
    private Double balance;
    private Date createAt;
    private ProductResponseDto product;
}
