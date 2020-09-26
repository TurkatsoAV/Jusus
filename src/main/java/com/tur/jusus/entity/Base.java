package com.tur.jusus.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class Base {

    @Id
    @GeneratedValue
    private UUID uuid;
}
