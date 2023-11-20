package com.ifsuldeminas.telefonia.model.entity.comercial;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;

@Entity
public class Ligacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    private Date data;
    private int duracao;
}
