package com.ib.prueba.adapter.out.persistence;

import com.ib.prueba.application.port.out.ClientPort;
import com.ib.prueba.domain.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ClientRepository implements ClientPort {

    @Autowired
    ClientCrudRepository clientCrudRepository;

    @Override
    public Mono<ClientEntity> saveClient(ClientEntity clientEntity) {
        return Mono.just(clientCrudRepository.save(clientEntity));
    }

    @Override
    public void deleteClient(String id) {
        clientCrudRepository.deleteById(id);
    }

    @Override
    public Mono<ClientEntity> getClientById(String id) {
        return Mono.justOrEmpty(clientCrudRepository.findById(id));
    }

    @Override
    public Mono<ClientEntity> updateClient(ClientEntity clientEntity) {
        return Mono.just(clientCrudRepository.save(clientEntity));
    }


}
