package fr.mmarie.jdbi.folder.example.core.database;

import com.github.rkmk.container.FoldingListContainerFactory;
import com.github.rkmk.mapper.CustomMapperFactory;
import fr.mmarie.jdbi.folder.example.core.entities.Actor;
import fr.mmarie.jdbi.folder.example.core.entities.Department;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 * Created by Maximilien on 05/12/2014.
 */
public class Initialize {
    private final Handle handle;

    public Initialize(DBI dbi) {
        this.handle = dbi.open();
        folding(dbi);
        dropTables();
        createTables();
    }

    public void folding(DBI dbi) {
        dbi.registerMapper(new CustomMapperFactory());
        dbi.registerContainerFactory(new FoldingListContainerFactory());
    }

    public void createTables() {
        handle.execute("create table actor (id numeric not null, last_name varchar(100) not null, first_name varchar(100) not null, department_id numeric not null,  ratings numeric);");
        handle.execute("create table department (id numeric, name varchar(100) not null);");
    }

    public void dropTables() {
        handle.execute("drop table if exists actor;");
        handle.execute("drop table if exists department;");
    }

    public void insert(Actor... actors) {
        for (Actor actor : actors) {
            handle.execute("insert into actor(id, last_name, first_name, department_id) values(?,?,?,?)", actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getDepartmentId());
        }
    }

    public void insert(Department... departments) {
        for (Department department : departments) {
            handle.execute("insert into department(id, name) values(?,?)", department.getId(), department.getName());
        }
    }


}
