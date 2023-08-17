package com.vnoxiaene.deliverando.service;

import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;

public interface ClienteService {

    public void create(ClienteDTO clienteDTO);

    ClienteResponseDTO update(ClienteDTO clienteDTO, Long id);
}