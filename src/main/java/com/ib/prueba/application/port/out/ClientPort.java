package com.ib.prueba.application.port.out;

import com.ib.prueba.domain.ClientEntity;
import reactor.core.publisher.Mono;

public interface ClientPort {

    Mono<ClientEntity> saveClient(ClientEntity clientEntity);

    void deleteClient(String id);

    Mono<ClientEntity> getClientById(String id);

    Mono<ClientEntity> updateClient(ClientEntity clientEntity);

}
