package com.ib.prueba.adapter.in.web.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String id;
    private long accountNumber;
    private String accountType;
    private long initialBalance;
    private boolean state;
    private String clientId;
}
