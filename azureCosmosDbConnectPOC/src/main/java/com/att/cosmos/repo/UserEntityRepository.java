package com.att.cosmos.repo;


import org.springframework.stereotype.Repository;

import com.att.cosmos.entity.UserEntity;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;

import reactor.core.publisher.Flux;

import reactor.core.publisher.Flux;
/**
 * @author Amir Khan
 * ReactiveCosmosRepository Interface for generic CRUD operations on a repository for a specific type.
 */
@Repository
public interface UserEntityRepository extends ReactiveCosmosRepository<UserEntity, String>{
	Flux<UserEntity> findByFirstName(String firstName);
}
