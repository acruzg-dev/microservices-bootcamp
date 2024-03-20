package com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.documents;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ProductBankAccount {

    private String id;
    private String name;
    private Double commission;
    private Double movementLimit;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date transactionDate;
    private Date createdAt;
    
    
}
