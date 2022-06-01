package com.pushka.alfatask.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Getter
@Setter
public class Currency {
    private String base;
    private Map<String, Double> rates;
}
