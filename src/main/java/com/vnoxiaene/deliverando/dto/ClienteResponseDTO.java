package com.vnoxiaene.deliverando.dto;

import lombok.Data;

import java.util.List;
@Data
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private List<PedidoDTO> pedidos;
}
