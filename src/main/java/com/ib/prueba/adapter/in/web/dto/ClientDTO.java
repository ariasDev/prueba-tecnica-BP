package com.ib.prueba.adapter.in.web.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String id;
    private long documentNumber;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String phoneNumber;
    private String password;
    private boolean state;
}
