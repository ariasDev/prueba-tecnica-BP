package com.ib.prueba.adapter.out.persistence;

import com.ib.prueba.application.port.out.AccountPort;
import com.ib.prueba.domain.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository implements AccountPort {

    @Autowired
    AccountCrudRepository accountCrudRepository;

    @Override
    public AccountEntity savAccount(AccountEntity accountEntity) {
        return accountCrudRepository.save(accountEntity);
    }

    @Override
    public void deleteAccount(String id) {
        accountCrudRepository.deleteById(id);
    }

    @Override
    public AccountEntity getAccountById(String id) {
        return accountCrudRepository.findById(id).orElse(new AccountEntity());
    }

    @Override
    public AccountEntity updateAccount(AccountEntity accountEntity) {
        return savAccount(accountEntity);
    }
}
