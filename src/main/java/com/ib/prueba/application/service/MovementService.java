package com.ib.prueba.application.service;

import com.ib.prueba.adapter.in.web.dto.MovementDTO;
import com.ib.prueba.application.port.in.MovementUseCase;
import com.ib.prueba.application.port.out.MovementPort;
import com.ib.prueba.domain.MovementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService implements MovementUseCase {

    @Autowired
    MovementPort movementPort;

    @Override
    public MovementDTO savMovement(MovementDTO movementDTO) {
        MovementEntity movementEntity = generateMovementEntity(movementDTO);
        MovementEntity movementEntitySaved = movementPort.saveMovement(movementEntity);
        movementDTO.setId(movementEntitySaved.getId());
        return movementDTO;
    }

    @Override
    public void deleteMovement(String id) throws Exception {
        MovementEntity movementEntity = movementPort.getMovementById(id);
        if (movementEntity.getId().isEmpty()) {
            throw new Exception("item does not exist");
        } else {
            movementPort.deleteMovement(id);
        }
    }

    @Override
    public MovementDTO getMovementById(String id) throws Exception {
        MovementEntity movementEntity = movementPort.getMovementById(id);
        if (movementEntity.getId().isEmpty()) {
            throw new Exception("item does not exist");
        } else {
            return generateMovementDTO(movementEntity);
        }
    }

    @Override
    public MovementDTO updateMovement(MovementDTO movementDTO) throws Exception {
        if (movementDTO.getId().isEmpty() || movementDTO.getId().isBlank()) {
            throw new Exception("account id is null");
        }
        MovementEntity movementEntity = generateMovementEntity(movementDTO);
        movementEntity.setId(movementEntity.getId());
        MovementEntity movementEntityUpdated = movementPort.updateMovement(movementEntity);
        return generateMovementDTO(movementEntityUpdated);
    }

    private MovementEntity generateMovementEntity(MovementDTO movementDTO) {
        return MovementEntity.builder()
                .date(movementDTO.getDate())
                .type(movementDTO.getType())
                .accountNumber(movementDTO.getAccountNumber())
                .value(movementDTO.getValue())
                .initialBalance(movementDTO.getInitialBalance())
                .build();
    }

    private MovementDTO generateMovementDTO(MovementEntity movementEntity) {
        return MovementDTO.builder()
                .id(movementEntity.getId())
                .accountNumber(movementEntity.getAccountNumber())
                .date(movementEntity.getDate())
                .type(movementEntity.getType())
                .value(movementEntity.getValue())
                .initialBalance(movementEntity.getInitialBalance())
                .build();
    }
}
