package com.razvan.repository;

import com.razvan.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author razvan adam
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
