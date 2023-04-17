package com.rijai.omt.omtserver.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class PriceData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int  id;
    int inventoryId;
    Date startDate;
    Date endDate;
    double price;
}
