package com.ifsuldeminas.telefonia.model.entity;

import java.util.Set;

import com.ifsuldeminas.telefonia.model.entity.comercial.Celular;
import com.ifsuldeminas.telefonia.model.entity.comercial.Plano;
import com.ifsuldeminas.telefonia.model.entity.pessoal.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Operadora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Cliente> clientes;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Celular> celulares;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Plano> planos;
}
