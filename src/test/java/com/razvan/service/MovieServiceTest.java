package com.razvan.service;

import com.razvan.controller.MovieController;
import com.razvan.model.Movie;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class)
public class MovieServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieServiceMock;

    List<Movie> moviesMock = Arrays.asList(
            new Movie("Gladiator", 15.50, 80, true),
            new Movie("Matrix", 12.25, 95, false)
    );

    @Test
    public void testGetAllMoviesReturnsJson() throws Exception {
        when(movieServiceMock.getAllMovies()).thenReturn(moviesMock);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movies").
                accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{name:Gladiator, price:15.50,length:80,available:true}," +
                "{name:Matrix,price:12.25,length:95,available:false}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}