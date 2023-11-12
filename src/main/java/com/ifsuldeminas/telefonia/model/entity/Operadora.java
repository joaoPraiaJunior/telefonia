package com.ifsuldeminas.telefonia.model.entity;

import java.util.Set;

import com.ifsuldeminas.telefonia.model.entity.comercial.Celular;
import com.ifsuldeminas.telefonia.model.entity.comercial.Plano;
import com.ifsuldeminas.telefonia.model.entity.pessoal.Cliente;

public class Operadora {
    private String nome;
    private Set<Cliente> clientes;
    private Set<Celular> celulares;
    private Set<Plano> planos;
}
