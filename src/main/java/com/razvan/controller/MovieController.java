package com.razvan.controller;

import com.razvan.model.Movie;
import com.razvan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author razvan adam
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Returns a List<Movie> containing all the movies in the movie collection
     * @return List<Movie> all movies inside movie collection
     */
    @RequestMapping("")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * Adds a new movie to the movie collection and return its value.
     * @param name String name of the movie
     * @param price double price of the movie
     * @param length int length in minutes of the movie
     * @param available boolean availability of the movie in the store
     * @return Movie prints the movie added
     */
    @RequestMapping("/add")
    public Movie addMovie(@RequestParam String name, @RequestParam double price,
                     @RequestParam int length, @RequestParam boolean available) {
        return movieService.addMovie(name, price, length, available);
    }

    /**
     * Searches for a movie by the name passed as parameter and returns
     * the movie if it finds it
     * @param name String name used to search for the movie
     * @return Movie the movie matching the name parameter
     */
    @RequestMapping("/name")
    public Movie findById(@RequestParam String name) {
        return movieService.findByName(name);
    }

    /**
     * Updates the price of a movie searched by name and returns the movie info
     * in a String
     * @param name String name of the movie to be searched
     * @param price double new price value
     * @return String containing the information of the movie updated
     */
    @RequestMapping("/update-price")
    public String updateMoviePrice(@RequestParam String name, @RequestParam double price) {
        Movie movie = movieService.updateMoviePrice(name, price);
        return "Updated: " + movie.toString();
    }

    /**
     * Removes a movie searched by name and returns the movie info in a String
     * @param name String name of the movie to be removed
     * @return String containing the information of the movie removed
     */
    @RequestMapping("/remove")
    public String removeMovie(@RequestParam String name) {
        Movie movie = movieService.removeMovie(name);
        return movie.toString();
    }
}
