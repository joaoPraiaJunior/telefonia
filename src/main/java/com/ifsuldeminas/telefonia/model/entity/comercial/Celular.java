package com.ifsuldeminas.telefonia.model.entity.comercial;

import java.util.Set;

import com.ifsuldeminas.telefonia.model.entity.pessoal.Cliente;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "class")
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long numero;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    @JoinColumn(name = "celular_id")
    private Set<Ligacao> ligacoes;
    @ManyToOne
    private Plano plano;
}
