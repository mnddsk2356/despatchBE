package com.dispatch.application.repository;


import com.dispatch.application.entities.Owner;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface OwnerDetailRepo extends CrudRepository<Owner, Integer> {

    @Transactional
    @Modifying
    @Query("Delete From Owner where id =:ownerDetailsId")
    void removeByOwnerDetailsId(@Param("ownerDetailsId") int ownerDetailsId);
}
