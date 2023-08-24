package com.vnoxiaene.deliverando.service;

import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;
import com.vnoxiaene.deliverando.dto.PedidoDTO;

public interface ClienteService {

    public void create(ClienteDTO clienteDTO);

    void update(ClienteDTO clienteDTO, Long id);

    void delete(Long id);

    ClienteResponseDTO get(Long id);

    ClienteResponseDTO addPedido(Long id, PedidoDTO pedidoDTO);
}
