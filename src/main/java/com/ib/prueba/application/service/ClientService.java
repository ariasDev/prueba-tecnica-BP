package com.ib.prueba.application.service;

import com.ib.prueba.adapter.in.web.dto.ClientDTO;
import com.ib.prueba.application.port.in.ClientUseCase;
import com.ib.prueba.application.port.out.ClientPort;
import com.ib.prueba.domain.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements ClientUseCase {

    @Autowired
    ClientPort clientPort;

    @Override
    public Mono<ClientDTO> saveClient(ClientDTO clientDTO) {

        ClientEntity clientEntity = generateClientEntity(clientDTO);

        return clientPort.saveClient(clientEntity)
                .map(client -> {
                    clientDTO.setId(client.getId());
                    return clientDTO;
                });
    }


    @Override
    public Mono<ClientDTO> updateClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = generateClientEntity(clientDTO);
        clientEntity.setId(clientDTO.getId());

        clientPort.updateClient(clientEntity);

        return Mono.just(clientDTO);
    }

    @Override
    public Mono<ClientDTO> findById(String id) {
        return clientPort.getClientById(id)
                .map(clientEntity -> ClientDTO.builder()
                        .id(clientEntity.getId())
                        .documentNumber(clientEntity.getDocumentNumber())
                        .name(clientEntity.getName())
                        .gender(clientEntity.getGender())
                        .age(clientEntity.getAge())
                        .address(clientEntity.getAddress())
                        .phoneNumber(clientEntity.getPhoneNumber())
                        .password(clientEntity.getPassword())
                        .state(clientEntity.isState())
                        .build());
    }

    @Override
    public void deleteCliente(String id) {
        clientPort.deleteClient(id);
    }


    private ClientEntity generateClientEntity(ClientDTO clientDTO) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setDocumentNumber(clientDTO.getDocumentNumber());
        clientEntity.setName(clientDTO.getName());
        clientEntity.setGender(clientDTO.getGender());
        clientEntity.setAge(clientDTO.getAge());
        clientEntity.setAddress(clientDTO.getAddress());
        clientEntity.setPhoneNumber(clientDTO.getPhoneNumber());
        clientEntity.setPassword(clientDTO.getPassword());
        clientEntity.setState(clientDTO.isState());
        return clientEntity;
    }
}
