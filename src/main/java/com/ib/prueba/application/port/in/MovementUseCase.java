package com.ib.prueba.application.port.in;

import com.ib.prueba.adapter.in.web.dto.MovementDTO;

public interface MovementUseCase {

    MovementDTO savMovement(MovementDTO accountDTO);

    void deleteMovement(String id) throws Exception;

    MovementDTO getMovementById(String id) throws Exception;

    MovementDTO updateMovement(MovementDTO accountDTO) throws Exception;
}
