package com.razvan.repository;

import com.razvan.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author razvan adam
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    /**
     * Custom repository method used to search a movie by its name
     * @param name String name of the movie
     * @return Movie movies with the name passed as parameter
     */
    public Movie findByName(String name);
}
