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
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Adds a movie to the movie collection and returns the movie added.
     * @param name String name of the movie
     * @param price double price of the movie
     * @param length int length in minutes
     * @param available boolean availability of the movie in the store
     * @return Movie prints the movie added
     */
    public Movie addMovie(String name, double price, int length, boolean available) {
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

    /**
     * Updates the price of a movie searched by name and returns the movie
     * @param name String name of the movie to be searched
     * @param price double new price value
     * @return Movie movie updated
     */
    public Movie updateMoviePrice(String name, double price) {
        Movie movie = movieRepository.findByName(name);
        movie.setPrice(price);
        return movieRepository.save(movie);
    }

    /**
     * Removes a movie searched by name and returns the Movie Object
     * @param name String name of the movie to be removed
     * @return Movie movie removed
     */
    public Movie removeMovie(String name) {
        Movie movie = movieRepository.findByName(name);
        movieRepository.delete(movie);
        return movie;
    }
}
