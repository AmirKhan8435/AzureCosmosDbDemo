package com.att.cosmos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.att.cosmos.entity.UserEntity;
import com.att.cosmos.repo.UserEntityRepository;

@SpringBootApplication
public class SpringCosmosDbTestApplication implements CommandLineRunner {

	@Autowired
	UserEntityRepository userEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCosmosDbTestApplication.class, args);
	}

	/**
	 * @author Amir Khan
	 * Here are some examples of operation with Azure Cosmos DB Emulator as a demo
	 */
	@Override
	public void run(String... args) throws Exception {
		//
		
		//For getting all data 
		List<UserEntity> allUserList = userEntityRepository.findAll().collectList().block();
		for (UserEntity userEntity : allUserList) {
			System.out.println(userEntity.toString());
		}
		
		//For getting data/list of data using particular field of entity eg.FindByFirstName
		List<UserEntity> firstNameUser = userEntityRepository.findByFirstName("John").collectList().block();
		for (UserEntity userEntity : firstNameUser) {
			System.out.println(userEntity.toString());
		}
		
		//Saving our entity in the database
		UserEntity addUser = new UserEntity("Domnic", 56);
		userEntityRepository.save(addUser).block();
	}

}
