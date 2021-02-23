package com.mila.springframework.netfluxexample.bootstrap;

import com.mila.springframework.netfluxexample.domain.Movie;
import com.mila.springframework.netfluxexample.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;
@AllArgsConstructor
@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public void run(String... args) {
        movieRepository.deleteAll().thenMany(
                Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>",
                        "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                        .map(title -> new Movie(UUID.randomUUID().toString(), title))
                        .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
