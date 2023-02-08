package com.ib.prueba.adapter.in.web.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementDTO {

    private String id;
    private long accountNumber;
    private String date;
    private String type;
    private long value;
    private long initialBalance;
}
