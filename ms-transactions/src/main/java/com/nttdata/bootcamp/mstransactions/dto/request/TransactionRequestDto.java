package com.nttdata.bootcamp.mstransactions.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestDto {

    private String numberAccount;
    private String amount;
}
