package com.pbp.ecommercecomputer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private UUID id;

    private String name;

    private String description;

    private String image;

    private int amount;

    private Long price;

    private String categoryName;
}
