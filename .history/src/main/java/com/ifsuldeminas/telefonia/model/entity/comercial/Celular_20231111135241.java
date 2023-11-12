package com.ifsuldeminas.telefonia.model.entity.comercial;

import java.util.Set;

import com.ifsuldeminas.telefonia.model.entity.pessoal.Cliente;

public class Celular {
    private long numero;
    private Cliente cliente;
    private Set<Ligacao> ligacoes;
    private Plano plano;
}
