package com.vnoxiaene.deliverando.service;

import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;
import com.vnoxiaene.deliverando.mapper.ClienteMapper;
import com.vnoxiaene.deliverando.model.Cliente;
import com.vnoxiaene.deliverando.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    @Override
    public void create(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.INSTANCE.dtoToEntity(clienteDTO);
        clienteRepository.save(cliente);
    }

    @Override
    public ClienteResponseDTO update(ClienteDTO clienteDTO, Long id) {
        return null;
    }
}
