package com.nttdata.bootcamp.mspersonalproduct.models.documents;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Product {

    private String id;
    private String name;
    private Double commission;
    private Double movementLimit;
    // @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date transactionDate;
    private Date createdAt;
}
