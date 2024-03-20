package com.nttdata.bootcamp.mspersonalproduct.models.dtos;

import java.util.Date;
import java.util.List;

import com.nttdata.bootcamp.mspersonalproduct.models.documents.CustomerPersonal;
import com.nttdata.bootcamp.mspersonalproduct.models.documents.PersonalProduct;

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
    private String id;
    private String numberDocument;
    private String name;
    private String lastname;
    private String address;
    private String phone;

    private List<PersonalProduct> personalProducts;
}
