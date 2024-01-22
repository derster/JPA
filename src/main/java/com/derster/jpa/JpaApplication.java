package com.derster.jpa;

import com.derster.jpa.models.Author;
import com.derster.jpa.models.Video;
import com.derster.jpa.repositories.AuthorRepository;
import com.derster.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository){
		return args -> {
			Date date = new Date();
			/*var author = Author.builder()
					.firstName("Modeste")
					.lastName("KOUADIO")
					.email("modstk1@gmail.com")
					.createdAt(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
					.age(39)
					.build();
			authorRepository.save(author);*/

			var video = Video.builder()
					.length(5)
					.name("abc")
					.build();
			videoRepository.save(video);
		};
	}

}
