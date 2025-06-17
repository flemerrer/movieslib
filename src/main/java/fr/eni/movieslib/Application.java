package fr.eni.movieslib;

import fr.eni.movieslib.bo.movies.Movie;
import fr.eni.movieslib.controllers.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        MovieController controller = context.getBean(MovieController.class);
        controller.service.init();
    }

}
