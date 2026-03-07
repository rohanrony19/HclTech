package com.example.reactivestream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactivestreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivestreamApplication.class, args);
		Mono<Integer> n = Mono.just(10);
		Flux<Integer> k = Flux.just(1,2,3,4,5);
		n.subscribe(p->System.out.println(p));
		k.subscribe(p->System.out.println(p));

		
	}

}
