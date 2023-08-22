package com.vnoxiaene.deliverando.dto;

import com.vnoxiaene.deliverando.model.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private String nome;
    private List<PedidoDTO> pedidos;
}
