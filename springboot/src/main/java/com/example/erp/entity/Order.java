package com.example.erp.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer gameId;
    private Integer number;
}
