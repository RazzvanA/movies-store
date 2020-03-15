package com.razvan.service;

import com.razvan.model.Movie;
import com.razvan.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author razvan adam
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Searches in the movie collection and returns a List<Movie> containing all
     * the movies from this collection.
     * @return List<Movie> all the movies in the collection movies
     */
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    /**
     * Adds a movie to the movie collection and returns the movie added.
     * @param name String name of the movie
     * @param price double price of the movie
     * @param length int length in minutes
     * @param available boolean availability of the movie
     * @return Movie prints the movie added
     */
    public Movie add(String name, double price, int length, boolean available) {
        return movieRepository.save(new Movie(name, price, length, available));
    }

    /**
     * Searches for a movies which matches the name passed as parameter
     * @param name String name of the move to search for
     * @return Movie movie matching the name parameter
     */
    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }
}
