package com.vnoxiaene.deliverando.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private String nome;
    private String telefone;
    private List<PedidoDTO> pedidos;
}
