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
        optionalCliente.ifPresent(cliente -> {
            cliente.setNome(clienteDTO.getNome());
            List<Pedido> pedidos = new ArrayList<>();
            List<PedidoDTO> dtoPedidos = clienteDTO.getPedidos();
            dtoPedidos.forEach(pedidoDTO -> {
                Pedido pedido = getPedido(pedidoDTO);
                pedidos.add(pedido);
            });
            cliente.setPedidos(pedidos);
        });
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
}
