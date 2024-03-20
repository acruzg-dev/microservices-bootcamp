package com.nttdata.bootcamp.mspersonalproduct.models.documents;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "customers_personal_products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalProduct {

    @Id
    private String id;
    private ObjectId customerPersonalId;
    private String productId;
    private String numberAccount;
    private Double balance;
    private Date createAt;
}