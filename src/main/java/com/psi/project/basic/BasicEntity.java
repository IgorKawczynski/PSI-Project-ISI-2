package com.psi.project.basic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class BasicEntity {

    public static final String ID_NAME = "id_sequence";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_generator")
    @SequenceGenerator(name = "base_generator", sequenceName = ID_NAME, allocationSize = 1)
    protected Long id;

}
