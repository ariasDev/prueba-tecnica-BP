package com.ib.prueba.adapter.in.web;

import com.ib.prueba.adapter.in.web.dto.AccountDTO;
import com.ib.prueba.application.port.in.AccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class AccountController {

    @Autowired
    AccountUseCase accountUseCase;

    @PostMapping
    ResponseEntity<Object> saveAccount(@RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO accountDTOResponse = accountUseCase.savAccount(accountDTO);
            return ResponseEntity.ok(accountDTOResponse);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping
    ResponseEntity<Object> updateAccount(@RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO accountDTOResponse = accountUseCase.updateAccount(accountDTO);
            return ResponseEntity.ok(accountDTOResponse);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    ResponseEntity<Object> findAccountById(@PathVariable("id") String id) {
        try {
            AccountDTO accountDTOResponse = accountUseCase.getAccountById(id);
            return ResponseEntity.ok(accountDTOResponse);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteAccount(@PathVariable("id") String id) {
        try {
            accountUseCase.deleteAccount(id);
            return ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getLocalizedMessage());
        }
    }

}
