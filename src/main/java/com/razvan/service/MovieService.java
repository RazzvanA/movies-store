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

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie add(String name, double price, int length, boolean available) {
        return movieRepository.save(new Movie(name, price, length, available));
    }
}
