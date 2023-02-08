package com.ib.prueba.adapter.out.persistence;

import com.ib.prueba.application.port.out.MovementPort;
import com.ib.prueba.domain.MovementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovementRepository implements MovementPort {

    @Autowired
    MovementsCrudRepository movementsCrudRepository;

    @Override
    public MovementEntity saveMovement(MovementEntity movementEntity) {
        return movementsCrudRepository.save(movementEntity);
    }

    @Override
    public void deleteMovement(String id) {
        movementsCrudRepository.deleteById(id);
    }

    @Override
    public MovementEntity getMovementById(String id) {
        return movementsCrudRepository.findById(id).orElse(new MovementEntity());
    }

    @Override
    public MovementEntity updateMovement(MovementEntity movementEntity) {
        return movementsCrudRepository.save(movementEntity);
    }
}
