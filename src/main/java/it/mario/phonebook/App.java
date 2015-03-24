package it.mario.phonebook;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import it.mario.phonebook.resources.ContactResource;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Mario Grimaldi <mario.grimaldi89@gmail.com> with <3
 */
public class App extends Application<PhonebookConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(PhonebookConfiguration configuration, Environment environment) throws Exception {
        logger.info("Metodo App#run() chiamato");
        for (int i = 0; i < configuration.getMessageRepetitions(); i++) {
            System.out.println(configuration.getMessage());
        }

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "mysql");

        environment.jersey().register(new ContactResource(jdbi));
    }
}
