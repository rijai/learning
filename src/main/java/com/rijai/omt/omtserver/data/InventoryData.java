package com.rijai.omt.omtserver.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class InventoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int productId;
    private String skuId;
    private int stock;
    private int reserved;
}
