package com.vnoxiaene.deliverando.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidoDTO {
    private String descricao;
    private BigDecimal valor;
}
