package com.ib.prueba.application.service;

import com.ib.prueba.adapter.in.web.dto.AccountDTO;
import com.ib.prueba.application.port.in.AccountUseCase;
import com.ib.prueba.application.port.out.AccountPort;
import com.ib.prueba.domain.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountUseCase {

    @Autowired
    AccountPort accountPort;

    @Override
    public AccountDTO savAccount(AccountDTO accountDTO) {
        AccountEntity accountEntity = generateAccountEntity(accountDTO);
        AccountEntity accountEntitySaved = accountPort.savAccount(accountEntity);
        accountDTO.setId(accountEntitySaved.getId());
        return accountDTO;
    }

    @Override
    public void deleteAccount(String id) throws Exception {
        AccountEntity accountEntity = accountPort.getAccountById(id);
        if (accountEntity.getId().isEmpty()) {
            throw new Exception("item does not exist");
        } else {
            accountPort.deleteAccount(id);
        }
    }

    @Override
    public AccountDTO getAccountById(String id) throws Exception {
        AccountEntity accountEntity = accountPort.getAccountById(id);
        if (accountEntity.getId().isEmpty()) {
            throw new Exception("item does not exist");
        } else {
            return AccountDTO.builder()
                    .id(accountEntity.getId())
                    .accountNumber(accountEntity.getAccountNumber())
                    .accountType(accountEntity.getAccountType())
                    .initialBalance(accountEntity.getInitialBalance())
                    .state(accountEntity.isState())
                    .clientId(accountEntity.getClientId())
                    .build();
        }

    }

    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO) throws Exception {
        if (accountDTO.getId().isEmpty() || accountDTO.getId().isBlank()) {
            throw new Exception("account id is null");
        }
        AccountEntity accountEntity = generateAccountEntity(accountDTO);
        accountEntity.setId(accountDTO.getId());
        AccountEntity accountEntityUpdated = accountPort.updateAccount(accountEntity);
        return AccountDTO.builder()
                .id(accountEntityUpdated.getId())
                .accountNumber(accountEntityUpdated.getAccountNumber())
                .accountType(accountEntityUpdated.getAccountType())
                .initialBalance(accountEntityUpdated.getInitialBalance())
                .state(accountEntityUpdated.isState())
                .clientId(accountEntityUpdated.getClientId())
                .build();
    }

    private AccountEntity generateAccountEntity(AccountDTO accountDTO) {
        return AccountEntity.builder()
                .accountNumber(accountDTO.getAccountNumber())
                .accountType(accountDTO.getAccountType())
                .initialBalance(accountDTO.getInitialBalance())
                .state(accountDTO.isState())
                .clientId(accountDTO.getClientId())
                .build();
    }
}
