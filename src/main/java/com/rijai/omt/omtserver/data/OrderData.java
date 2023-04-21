package com.rijai.omt.omtserver.data;

import com.rijai.omt.omtserver.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table
@Entity
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int customerId;

    private OrderStatus status;

    private Date dateOrdered;
}
