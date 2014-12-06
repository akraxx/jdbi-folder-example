package fr.mmarie.jdbi.folder.example.core.entities;

import com.github.rkmk.annotations.OneToMany;
import com.github.rkmk.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.List;

/**
 * Created by Maximilien on 05/12/2014.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Department {
    @PrimaryKey
    private int id;

    private String name;

    @OneToMany("actor")
    private List<Actor> actors;
}