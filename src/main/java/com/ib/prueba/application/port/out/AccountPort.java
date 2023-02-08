package com.ib.prueba.application.port.out;

import com.ib.prueba.domain.AccountEntity;

public interface AccountPort {

    AccountEntity saveAccount(AccountEntity accountEntity);

    void deleteAccount(String id);

    AccountEntity getAccountById(String id);

    AccountEntity updateAccount(AccountEntity accountEntity);
}
