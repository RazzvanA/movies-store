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
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    /**
     * Adds a new movie to the movie collection and return its value.
     * @param name String name of the movie
     * @param price double price of the movie
     * @param length int length in minutes of the movie
     * @param available boolean availability in store of the movie
     * @return Movie prints the movie added
     */
    @RequestMapping("/add")
    public Movie add(@RequestParam String name, @RequestParam double price,
                     @RequestParam int length, @RequestParam boolean available) {
        return movieService.add(name, price, length, available);
    }

    @RequestMapping("/name")
    public Movie findById(@RequestParam String name) {
        return movieService.findByName(name);
    }
}
