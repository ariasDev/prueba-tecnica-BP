package com.ib.prueba.adapter.out.persistence;

import com.ib.prueba.domain.MovementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsCrudRepository extends CrudRepository<MovementEntity, String> {
}
