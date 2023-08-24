package com.vnoxiaene.deliverando.service;

import com.vnoxiaene.deliverando.dto.PedidoDTO;
import com.vnoxiaene.deliverando.dto.PedidoResponseDTO;

public interface PedidoService {
    void create(PedidoDTO pedidoDTO);

    void update(PedidoDTO pedidoDTO, Long id);

    void delete(Long id);

    PedidoResponseDTO get(Long id);
}
