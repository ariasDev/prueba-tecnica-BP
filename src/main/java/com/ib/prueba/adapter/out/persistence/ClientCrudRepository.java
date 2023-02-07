package com.ib.prueba.adapter.out.persistence;

import com.ib.prueba.domain.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCrudRepository extends CrudRepository<ClientEntity, String> {
}
