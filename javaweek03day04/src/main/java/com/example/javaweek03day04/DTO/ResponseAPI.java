package com.example.javaweek03day04.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@AllArgsConstructor @Data
public class ResponseAPI<T> {
    private T message;
    private Integer status;
}
