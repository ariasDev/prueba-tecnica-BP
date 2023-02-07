package com.ib.prueba.application.port.in;

import com.ib.prueba.adapter.in.web.dto.ClientDTO;
import reactor.core.publisher.Mono;

public interface ClientUseCase {

    Mono<ClientDTO> saveClient(ClientDTO clientDTO);

    Mono<ClientDTO> updateClient(ClientDTO clientDTO);

    Mono<ClientDTO> findById(String id);

    void deleteCliente(String id) throws Exception;
}
