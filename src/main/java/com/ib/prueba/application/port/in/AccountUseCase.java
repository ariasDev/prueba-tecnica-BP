package com.ib.prueba.application.port.in;

import com.ib.prueba.adapter.in.web.dto.AccountDTO;

public interface AccountUseCase {

    AccountDTO savAccount(AccountDTO accountDTO);

    void deleteAccount(String id) throws Exception;

    AccountDTO getAccountById(String id) throws Exception;

    AccountDTO updateAccount(AccountDTO accountDTO) throws Exception;
}
