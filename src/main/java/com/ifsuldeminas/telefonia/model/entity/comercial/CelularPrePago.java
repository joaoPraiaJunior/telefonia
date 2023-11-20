package com.ifsuldeminas.telefonia.model.entity.comercial;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

@Entity
@DiscriminatorValue(value = "CelularPrePago")
public class CelularPrePago extends Celular {
    private double saldo;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date dataDeValidade;
}
