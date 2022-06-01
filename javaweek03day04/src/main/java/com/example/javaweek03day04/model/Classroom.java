package com.example.javaweek03day04.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @Getter @Setter @NoArgsConstructor
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "id is required") ==> id is generated
    private Integer id;
    @NotEmpty(message = "name is required")
    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> student;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

}
