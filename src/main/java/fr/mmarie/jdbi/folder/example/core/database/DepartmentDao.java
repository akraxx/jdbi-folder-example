package fr.mmarie.jdbi.folder.example.core.database;

import com.github.rkmk.container.FoldingList;
import fr.mmarie.jdbi.folder.example.core.entities.Actor;
import fr.mmarie.jdbi.folder.example.core.entities.Department;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

/**
 * Created by Maximilien on 05/12/2014.
 */
public abstract class DepartmentDao {

    @SqlQuery("select " +
            "    d.id AS id, " +
            "    d.name AS name, " +
            "    a.id AS actor$id, " +
            "    a.last_name AS actor$lastName " +
            "from department d " +
            "left join actor a WHERE a.department_id = d.id " +
            "order by d.id")
    public abstract FoldingList<Department> getFoldingDepartments();
}
