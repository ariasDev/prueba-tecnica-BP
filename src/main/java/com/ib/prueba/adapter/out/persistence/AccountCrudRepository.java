package com.ib.prueba.adapter.out.persistence;

import com.ib.prueba.domain.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCrudRepository extends CrudRepository<AccountEntity, String> {
}
