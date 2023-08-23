package com.vnoxiaene.deliverando.controller;


import com.vnoxiaene.deliverando.dto.ClienteDTO;
import com.vnoxiaene.deliverando.dto.ClienteResponseDTO;
import com.vnoxiaene.deliverando.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "v1/cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid ClienteDTO clienteDTO){
        clienteService.create(clienteDTO);
        return ResponseEntity.ok().body("Created");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
        clienteService.update(clienteDTO, id);
        return ResponseEntity.ok().body("Updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        clienteService.delete( id);
        return ResponseEntity.ok().body("Deleted");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id){

        return ResponseEntity.ok().body(clienteService.get(id));
    }

}
