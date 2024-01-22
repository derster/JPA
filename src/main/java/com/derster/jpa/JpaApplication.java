package com.derster.jpa;

import com.derster.jpa.models.Author;
import com.derster.jpa.models.Video;
import com.derster.jpa.repositories.AuthorRepository;
import com.derster.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository){
		return args -> {
			Date date = new Date();


			 for (int i=0; i<50; i++){
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.email(faker.name().username()+"@gmail.com")
						.createdAt(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
						.age(faker.number().numberBetween(25, 60))
						.build();
				authorRepository.save(author);

			}


			var author = Author.builder()
					.id(7)
					.firstName("Modeste")
					.lastName("KOUADIO")
					.email("modstk1@gmail.com")
					.createdAt(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
					.age(39)
					.build();
			authorRepository.save(author);

			//authorRepository.updateAuthor(34, 1);

			//authorRepository.updateAuthorAge(55);
			List<Author> byNamedQuery = authorRepository.findByNamedQuery(10);

			byNamedQuery.forEach(System.out::println);

			authorRepository.updateByNameQuery(45);







			/*var author = Author.builder()
					.firstName("Modeste")
					.lastName("KOUADIO")
					.email("modstk1@gmail.com")
					.createdAt(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
					.age(39)
					.build();
			authorRepository.save(author);*/

			/*var video = Video.builder()
					.length(5)
					.name("abc")
					.build();
			videoRepository.save(video);*/
		};
	}

}
