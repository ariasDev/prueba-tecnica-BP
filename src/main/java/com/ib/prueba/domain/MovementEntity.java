package com.ib.prueba.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movement")
@Builder
public class MovementEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column
    private long accountNumber;

    @Column
    private String date;

    @Column
    private String type;

    @Column
    private long value;

    @Column
    private long initialBalance;
}
