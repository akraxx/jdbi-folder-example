package fr.mmarie.jdbi.folder.example.resources;

import fr.mmarie.jdbi.folder.example.core.database.ActorDao;
import fr.mmarie.jdbi.folder.example.core.entities.Actor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Maximilien on 05/12/2014.
 */
@Path("/actor")
public class ActorResource {
    private final ActorDao actorDao;

    public ActorResource(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getAllActors() {
        return actorDao.getActors();
    }
}
