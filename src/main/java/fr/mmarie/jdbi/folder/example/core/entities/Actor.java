package fr.mmarie.jdbi.folder.example.core.entities;

import com.github.rkmk.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by Maximilien on 05/12/2014.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Actor {
    @PrimaryKey
    private int id;

    private String firstName;

    private String lastName;

    private int departmentId;
}
