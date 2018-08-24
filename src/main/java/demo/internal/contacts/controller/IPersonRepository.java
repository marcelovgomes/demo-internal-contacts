package demo.internal.contacts.controller;

import demo.internal.contacts.domain.Person;

import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long>{
	// The all CRUD methods are provided:
	// save, findById, delete, etc 
	
	// Here you can create other methods
}