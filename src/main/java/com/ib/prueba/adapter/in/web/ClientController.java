package com.ib.prueba.adapter.in.web;

import com.ib.prueba.adapter.in.web.dto.ClientDTO;
import com.ib.prueba.application.port.in.ClientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientUseCase clientUseCase;

    @PostMapping
    Mono<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        return clientUseCase.saveClient(clientDTO);
    }

    @PutMapping
    Mono<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) {
        return clientUseCase.updateClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteClient(@PathVariable("id") String id) {
        try {
            clientUseCase.deleteCliente(id);
            return ResponseEntity.status(200).body(Mono.empty());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> getClient(@PathVariable("id") String id) {
        try {
            Mono<ClientDTO> clientDTOMono = clientUseCase.findById(id);
            return ResponseEntity.status(200).body(clientDTOMono);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }
}
