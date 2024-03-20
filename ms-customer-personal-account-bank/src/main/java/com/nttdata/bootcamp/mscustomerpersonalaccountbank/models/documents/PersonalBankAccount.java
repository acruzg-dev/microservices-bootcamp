package com.nttdata.bootcamp.mscustomerpersonalaccountbank.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "personal_bank_account")
public class PersonalBankAccount {

    @Id
    private String id;
    private String customerPersonalId;
    private String productBankAccount;
    private Date createdAt;

}
