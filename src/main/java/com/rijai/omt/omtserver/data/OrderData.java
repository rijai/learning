package com.rijai.omt.omtserver.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int customerId;

}
