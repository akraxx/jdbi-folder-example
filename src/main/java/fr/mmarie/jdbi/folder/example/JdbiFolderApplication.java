package fr.mmarie.jdbi.folder.example;

import fr.mmarie.jdbi.folder.example.core.database.ActorDao;
import fr.mmarie.jdbi.folder.example.core.database.DepartmentDao;
import fr.mmarie.jdbi.folder.example.core.database.Initialize;
import fr.mmarie.jdbi.folder.example.core.entities.Actor;
import fr.mmarie.jdbi.folder.example.core.entities.Department;
import fr.mmarie.jdbi.folder.example.resources.ActorResource;
import fr.mmarie.jdbi.folder.example.resources.DepartmentResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by Maximilien on 05/12/2014.
 */
public class JdbiFolderApplication extends Application<JdbiFolderConfiguration> {

    @Override
    public void initialize(Bootstrap<JdbiFolderConfiguration> bootstrap) {

    }

    @Override
    public void run(JdbiFolderConfiguration configuration, Environment environment) throws Exception {
        DBI dbi = new DBIFactory().build(environment, configuration.getDatabase(), "db-h2");
        Initialize initialize = new Initialize(dbi);
        initialize.insert(Actor.builder().id(1).lastName("lastName1").firstName("firstname 1").departmentId(1).build());
        initialize.insert(Department.builder().id(1).name("dptname").build());
        environment.jersey().register(new ActorResource(dbi.onDemand(ActorDao.class)));
        environment.jersey().register(new DepartmentResource(dbi.onDemand(DepartmentDao.class)));
    }

    public static void main(String[] args) throws Exception {
        new JdbiFolderApplication().run(new  String[] {"server", "properties.yml"});
    }
}
