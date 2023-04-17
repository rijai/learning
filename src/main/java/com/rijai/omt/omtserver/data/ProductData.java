package com.rijai.omt.omtserver.data;


import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int  id;
    private int categoryId;
    private String name;
    private String description;
    private String unitOfMeasure;
};
