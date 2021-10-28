package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	DemoService service;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDataWithJDBC() {
		List<Movie> movies = service.getDataWithJDBC(42);

		Assert.assertEquals("size of result is 3", 3, movies.size());
		Assert.assertEquals("first movie is Movie7", "Movie7", movies.get(0).getTitle());
		Assert.assertEquals("second movie is Movie2", "Movie2", movies.get(1).getTitle());
		Assert.assertEquals("third movie is Movie5", "Movie5", movies.get(2).getTitle());
	}

	@Test
	public void testDataWithJPA() {
		List<Movie> movies = service.getDataWithJPA(42);

		Assert.assertEquals("size of result is 3", 3, movies.size());
		Assert.assertEquals("first movie is Movie7", "Movie7", movies.get(0).getTitle());
		Assert.assertEquals("second movie is Movie2", "Movie2", movies.get(1).getTitle());
		Assert.assertEquals("third movie is Movie5", "Movie5", movies.get(2).getTitle());
	}

}
