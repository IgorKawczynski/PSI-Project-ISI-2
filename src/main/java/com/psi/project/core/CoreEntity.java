package com.psi.project.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class CoreEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
