package com.varma.productservice.dto;

import java.math.BigDecimal;

public record ProductResponse(Integer id, String name, String description, BigDecimal price) {
}
