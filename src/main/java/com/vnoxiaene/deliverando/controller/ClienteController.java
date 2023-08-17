package com.vnoxiaene.deliverando.controller;


import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;
import com.vnoxiaene.deliverando.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "v1/cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> create(ClienteDTO clienteDTO){
        clienteService.create(clienteDTO);
        return ResponseEntity.ok().body("Created");
    }

    public ResponseEntity<ClienteResponseDTO> update(ClienteDTO clienteDTO, Long id){
        return ResponseEntity.ok(clienteService.update(clienteDTO, id));
    }

}
