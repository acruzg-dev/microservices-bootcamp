package com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
public class CustomerPersonalDto {

    private String id;
    private String numberDocument;
    private String name;
    private String lastname;
    private String address;
    private String phone;
}
