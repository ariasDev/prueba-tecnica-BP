package com.ib.prueba.adapter.in.web;

import com.ib.prueba.adapter.in.web.dto.MovementDTO;
import com.ib.prueba.application.port.in.MovementUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovementsController {

    @Autowired
    MovementUseCase movementUseCase;

    @PostMapping
    ResponseEntity<Object> saveMovement(@RequestBody MovementDTO movementDTO) {
        try {
            MovementDTO movementDTOResponse = movementUseCase.savMovement(movementDTO);
            return ResponseEntity.ok(movementDTOResponse);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping
    ResponseEntity<Object> updateMovement(@RequestBody MovementDTO movementDTO) {
        try {
            MovementDTO movementDTOResponse = movementUseCase.updateMovement(movementDTO);
            return ResponseEntity.ok(movementDTOResponse);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    ResponseEntity<Object> findMovementById(@PathVariable("id") String id) {
        try {
            MovementDTO movementDTOResponse = movementUseCase.getMovementById(id);
            return ResponseEntity.ok(movementDTOResponse);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteMovement(@PathVariable("id") String id) {
        try {
            movementUseCase.deleteMovement(id);
            return ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }
}
