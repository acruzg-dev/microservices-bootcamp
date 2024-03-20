package com.nttdata.bootcamp.msproducts.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "products_banks_accounts")
public class ProductBankAccount {

    @Id
    private String id;
    private String name;
    private Double commission;
    private Double movementLimit;
    // @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date transactionDate;
    private Date createdAt;
}
