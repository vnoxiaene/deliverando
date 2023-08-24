package com.vnoxiaene.deliverando.controller;


import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;
import com.vnoxiaene.deliverando.dto.PedidoDTO;
import com.vnoxiaene.deliverando.dto.PedidoResponseDTO;
import com.vnoxiaene.deliverando.service.ClienteService;
import com.vnoxiaene.deliverando.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "v1/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid PedidoDTO pedidoDTO){
        pedidoService.create(pedidoDTO);
        return ResponseEntity.ok().body("Created");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody PedidoDTO pedidoDTO, @PathVariable Long id){
        pedidoService.update(pedidoDTO, id);
        return ResponseEntity.ok().body("Updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        pedidoService.delete( id);
        return ResponseEntity.ok().body("Deleted");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoResponseDTO> update(@PathVariable Long id){

        return ResponseEntity.ok().body(pedidoService.get(id));
    }

}
