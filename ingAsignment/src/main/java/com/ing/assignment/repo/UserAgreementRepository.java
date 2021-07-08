package com.ing.assignment.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAgreementRepository extends CrudRepository<UserAgreementEntity,Integer> {
    @Query("SELECT u FROM UserAgreementEntity u WHERE u.userId = :user")
    List<UserAgreementEntity> findAgreementByUser(int user);

}
