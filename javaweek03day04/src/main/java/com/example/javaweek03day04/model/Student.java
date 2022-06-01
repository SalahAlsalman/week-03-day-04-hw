package com.example.javaweek03day04.model;

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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "id is required") ==> id is generated
    private Integer id;
    @NotEmpty(message = "name is required")
    @Column(unique = true)
    private String name;
    @NotNull(message = "age is required")
    private Integer age;
    @NotEmpty(message = "major is required")
    private String major;

    @ManyToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<Classroom> classroom;

    
}
