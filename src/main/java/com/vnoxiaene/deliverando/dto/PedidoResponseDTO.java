package com.vnoxiaene.deliverando.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidoResponseDTO {

    private Long id;
    private String descricao;
    private BigDecimal valor;
}
