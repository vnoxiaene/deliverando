package com.vnoxiaene.deliverando.mapper;

import com.vnoxiaene.deliverando.dto.PedidoDTO;
import com.vnoxiaene.deliverando.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);
    Pedido dtoToEntity(PedidoDTO pedidoDTO);
}
