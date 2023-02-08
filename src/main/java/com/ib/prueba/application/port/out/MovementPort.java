package com.ib.prueba.application.port.out;

import com.ib.prueba.domain.MovementEntity;

public interface MovementPort {

    MovementEntity saveMovement(MovementEntity movementEntity);

    void deleteMovement(String id);

    MovementEntity getMovementById(String id);

    MovementEntity updateMovement(MovementEntity movementEntity);
}
