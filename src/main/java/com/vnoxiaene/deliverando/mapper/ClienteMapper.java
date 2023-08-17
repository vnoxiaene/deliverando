package com.vnoxiaene.deliverando.mapper;

import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.PedidoDTO;
import com.vnoxiaene.deliverando.model.Cliente;
import com.vnoxiaene.deliverando.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "pedidos", target = "pedidos")
    Cliente dtoToEntity(ClienteDTO clienteDTO);
}
