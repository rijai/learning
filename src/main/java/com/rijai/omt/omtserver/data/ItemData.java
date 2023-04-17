package com.rijai.omt.omtserver.data;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class ItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int orderId;

    private int quantity;

    private int inventoryId;
}
