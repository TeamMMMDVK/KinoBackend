package org.example.kinobackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kinobackend.model.Movie;
import org.example.kinobackend.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void testPostMovie_Success() throws Exception {
        Movie movie = new Movie();
        movie.setMovieID(1);
        movie.setTitle("Inception");
        movie.setDescription("A movie");
        movie.setDurationMin(2010.0);

        when(movieService.postMovie(any(Movie.class))).thenReturn(movie);

        mockMvc.perform(post("/api/v1/movie/create-movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(movie)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Inception"))
                .andExpect(jsonPath("$.description").value("A movie"))
                .andExpect(jsonPath("$.durationMin").value(2010.0));
    }
}
