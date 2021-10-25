package com.example.JpaDemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaDemoApplicationTests {

	@Autowired
	DogRepository repository;
	@Autowired
	OwnerRepository ownerRepository;


	@Test
	public void contextLoads() {
	}

	// Part 1

	@Test
	public void testFindDogs() {
		List<Dog> dogs = (List)repository.findAll();
		Assert.assertTrue("Found some dogs", dogs.size() > 0);
	}

	@Test
	public void testFindDog() {
		Dog dog = repository.findById(1L).get();
		Assert.assertEquals("Dog with id=1 is Pluto", "Pluto", dog.getName());
	}

	@Test
	public void testAddDog() {
		long count = repository.count();
		Dog dog = new Dog("New dog", 1);
		repository.save(dog);
		long count2 = repository.count();
		Assert.assertEquals("Count is increased by 1 when saving new dog", count+1, count2);
	}

	@Test
	public void testUpdateDog() {
		Dog dog = repository.findById(1L).get();
		int originalAge = dog.getAge();
		dog.setAge(originalAge+1);
		repository.save(dog);
		Dog dog2 = repository.findById(1L).get();
		Assert.assertEquals("Dog is updated in the database with age increased by 1", originalAge+1, dog2.getAge());
		// setting the age back to the original value
		dog.setAge(originalAge);
		repository.save(dog);
	}

	@Test
	public void testDeleteDog() {
		long count = repository.count();
		Dog dog = repository.findById(2L).get();
		repository.delete(dog);
		long count2 = repository.count();
		Assert.assertEquals("Count is decreased by 1 when deleting  dog", count-1, count2);
	}

	// Part 2

	@Test
	public void testFindDogByName() {
		List<Dog> dogs = (List)repository.findByName("Pluto");
		Assert.assertEquals("Finding dog with name Pluto", 1, dogs.size());
	}


	@Test
	public void testFindDogByAgeGreaterThan80() {
		List<Dog> dogs = (List)repository.findByAgeGreaterThan(80);
		Assert.assertEquals("Finding dog with age over 80", 1, dogs.size());
		Assert.assertEquals("Finding dog with age over 80", "Pluto", dogs.get(0).getName());
	}

	@Test
	public void testFindDogByNameAndByAgeMoreThan80() {
		List<Dog> dogs = (List)repository.findByNameAndAgeGreaterThan("Pluto", 80);
		Assert.assertEquals("Finding dog with name Pluto and age over 80", 1, dogs.size());
		Assert.assertEquals("Finding dog with name Pluto and age over 80", "Pluto", dogs.get(0).getName());
	}



	// Part 3

	@Test
	public void testCreateOwnerOfDog() {
		Dog dog = repository.findById(1L).get();
		Owner owner = new Owner("Mickey");
		ownerRepository.save(owner);
		dog.setOwner(owner);
		repository.save(dog);

		Dog dog2 = repository.findById(1L).get();

		Assert.assertEquals("Finding the owner of the dog", "Mickey", dog2.getOwner().getName());
	}


	@Test
	public void testGetDogsOfOwner() {
		// create dog and owner
		Dog dog = new Dog("new dog with owner", 10);
		Owner owner = new Owner("owner with dog");
		// save owner to create an id so it can be used in foreign key in dog
		ownerRepository.save(owner);
		// set owner to dog (foreign key will be the id of owner
		dog.setOwner(owner);
		// save the dog
		repository.save(dog);

		// get the same dog again
		Dog sameDog = repository.findById(dog.getId()).get();

		// assert it has a relation to it's owner
		Assert.assertEquals("Finding the owner of the dog", "owner with dog", sameDog.getOwner().getName());

		// set the dog as one of the dogs of the owner (to be able to get the dog by it's owner)
		owner.getDogs().add(dog);
		// save it
		ownerRepository.save(owner);

		// then get it again
		Owner sameOwner = ownerRepository.findById(owner.getId()).get();

		// assert that the dog was found through it's owner
		Assert.assertEquals("Finding the owner of the dog", "new dog with owner", owner.getDogs().get(0).getName());
	}

	@Test
	public void testFindDogByQueryAnnotation() {
		List<Dog> dogs = (List<Dog>)repository.findDogsWithQueryAge(90);
		Assert.assertEquals("Dog with Query Annotation should be Fido", "Pluto", dogs.get(0).getName());
	}
}

