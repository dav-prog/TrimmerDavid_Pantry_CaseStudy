package org.davidtrimmer.pantry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TrimmerDavidPantryCaseStudyApplication {
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(TrimmerDavidPantryCaseStudyApplication.class, args);
	}

}
