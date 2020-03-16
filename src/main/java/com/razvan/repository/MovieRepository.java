package com.razvan.repository;

import com.razvan.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author razvan adam
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    /**
     * Used to search a MMovie by its name
     * @param name String name of the Movie
     * @return Movie movies with the name passed as parameter
     */
    public Movie findByName(String name);

    /**
     * Used to search a List<Movie> which matched a price
     * @param price double price of the Movie
     * @return List<Movie> with the same price as the parameter
     */
    public List<Movie> findByPrice(double price);
}
