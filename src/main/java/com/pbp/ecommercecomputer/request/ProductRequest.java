package com.pbp.ecommercecomputer.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductRequest {

    private String name;

    private String description;

    private String image;

    private int amount;

    private Long price;

    private UUID categoryId;
}
