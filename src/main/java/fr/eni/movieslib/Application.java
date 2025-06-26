package fr.eni.movieslib;

import fr.eni.movieslib.controllers.MovieController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(Application.class, args);
//        MovieController controller = context.getBean(MovieController.class);
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception, IOException {

        ClassPathResource resource = new ClassPathResource("sql/filmotheque_script_mssql_insert.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(Objects.requireNonNull(jdbcTemplate.getJdbcTemplate().getDataSource()));
    }

    public Application(NamedParameterJdbcTemplate jdbcTemplate) {
        Application.jdbcTemplate = jdbcTemplate;
    }

}
