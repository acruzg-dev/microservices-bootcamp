package com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.documents;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class CustomerPersonal {
    private String id;
    private String numberDocument;
    private String name;
    private String lastname;
    private String address;
    private String phone;
}
