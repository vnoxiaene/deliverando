package com.vnoxiaene.deliverando.service;

import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;
import com.vnoxiaene.deliverando.dto.PedidoDTO;
import com.vnoxiaene.deliverando.exceptions.BadRequestException;
import com.vnoxiaene.deliverando.mapper.ClienteMapper;
import com.vnoxiaene.deliverando.mapper.PedidoMapper;
import com.vnoxiaene.deliverando.model.Cliente;
import com.vnoxiaene.deliverando.model.Pedido;
import com.vnoxiaene.deliverando.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void update(ClienteDTO clienteDTO, Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setTelefone(clienteDTO.getTelefone());
            List<PedidoDTO> dtoPedidos = clienteDTO.getPedidos();
            List<Pedido> pedidos = dtoPedidos.stream().map(PedidoMapper.INSTANCE::dtoToEntity).collect(Collectors.toList());
            cliente.getPedidos().clear();
            cliente.getPedidos().addAll(pedidos);
            clienteRepository.save(cliente);
        }
    }

    private static Pedido getPedido(PedidoDTO pedidoDTO) {
        return PedidoMapper.INSTANCE.dtoToEntity(pedidoDTO);
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        optionalCliente.ifPresent(cliente -> {
            clienteRepository.delete(cliente);
        });
    }

    @Override
    public ClienteResponseDTO get(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            return ClienteMapper.INSTANCE.entityToClienteResponseDTO(cliente);
        }else {
            throw new BadRequestException();
        }
    }

    @Override
    public ClienteResponseDTO addPedido(Long id,PedidoDTO pedidoDTO) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            Pedido pedido = PedidoMapper.INSTANCE.dtoToEntity(pedidoDTO);
            pedido.setCliente(cliente);
            cliente.getPedidos().add(pedido);
            Cliente savedCliente = clienteRepository.save(cliente);
            return ClienteMapper.INSTANCE.entityToClienteResponseDTO(savedCliente);
        }else{
            throw new BadRequestException("There's no client for this pedido.");
        }
    }
}
