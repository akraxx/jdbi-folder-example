package fr.mmarie.jdbi.folder.example.resources;

import fr.mmarie.jdbi.folder.example.core.database.DepartmentDao;
import fr.mmarie.jdbi.folder.example.core.entities.Actor;
import fr.mmarie.jdbi.folder.example.core.entities.Department;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Maximilien on 05/12/2014.
 */
@Path("/department")
public class DepartmentResource {
    private final DepartmentDao departmentDao;

    public DepartmentResource(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAllDepartments() {
        return departmentDao.getFoldingDepartments().getValues();
    }
}
