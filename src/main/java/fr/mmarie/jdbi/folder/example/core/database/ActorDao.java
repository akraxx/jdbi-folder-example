package fr.mmarie.jdbi.folder.example.core.database;

import com.github.rkmk.GenericFolder;
import com.github.rkmk.container.FoldingList;
import fr.mmarie.jdbi.folder.example.core.entities.Actor;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

import java.util.List;

/**
 * Created by Maximilien on 05/12/2014.
 */
public abstract class ActorDao {

    @SqlQuery("select * from actor")
    public abstract List<Actor> getActors();
}
