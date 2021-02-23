package com.mila.springframework.netfluxexample.service;

import com.mila.springframework.netfluxexample.domain.Movie;
import com.mila.springframework.netfluxexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    /**
     * Generate a stream of movie events for given movie id
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * Get a movie by id
     * @param id
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     * Return all movies
     * @return
     */
    Flux<Movie> getAllMovies();
}
