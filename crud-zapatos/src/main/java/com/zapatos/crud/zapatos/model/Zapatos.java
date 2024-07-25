package com.zapatos.crud.zapatos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Zapatos {
    private Long id;
    private String modelo;
    private String talla;
    private String color;
}
