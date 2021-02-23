package com.mila.springframework.netfluxexample.controller;

import com.mila.springframework.netfluxexample.domain.Movie;
import com.mila.springframework.netfluxexample.domain.MovieEvent;
import com.mila.springframework.netfluxexample.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/events/{movieId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> getMovieEvents(@PathVariable String movieId) {
        return movieService.events(movieId);
    }

    @GetMapping("/{movieId}")
    public Mono<Movie> getMovie(@PathVariable String movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();

    }
}
