package io.github.ahegaoboard.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
//@EnableWebFlux
public class AhegaoEngineApplication {

	public static void main(String[] args)
	{

		SpringApplication.run(AhegaoEngineApplication.class, args);
	}

}
