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

    @RequestMapping("")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @RequestMapping("/add")
    public Movie add(@RequestParam String name, @RequestParam double price,
                     @RequestParam int length, @RequestParam boolean available) {
        return movieService.add(name, price, length, available);
    }
}
