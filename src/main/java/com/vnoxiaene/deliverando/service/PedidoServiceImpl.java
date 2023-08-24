package com.vnoxiaene.deliverando.service;

import com.vnoxiaene.deliverando.dto.PedidoDTO;
import com.vnoxiaene.deliverando.dto.PedidoResponseDTO;
import com.vnoxiaene.deliverando.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    @Override
    public void create(PedidoDTO pedidoDTO) {

    }

    @Override
    public void update(PedidoDTO pedidoDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PedidoResponseDTO get(Long id) {
        return null;
    }
}
