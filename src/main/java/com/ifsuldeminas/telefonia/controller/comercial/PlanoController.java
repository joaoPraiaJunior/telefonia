package com.ifsuldeminas.telefonia.controller.comercial;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifsuldeminas.telefonia.model.entity.comercial.Plano;
import com.ifsuldeminas.telefonia.model.repositories.comercial.PlanoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/planos")
public class PlanoController {
    private PlanoRepository planoRepository;

    public PlanoController(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    // Método Listar
    @GetMapping
    public List<Plano> list() {
        return planoRepository.findAll();
    }

    // Método Mostrar
    @GetMapping("/{id}")
    public ResponseEntity<Plano> show(@Valid @PathVariable long id) {
        Optional<Plano> opt = planoRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<Plano>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
    }

    // Método Salvar/Criar
    @PostMapping
    public ResponseEntity<Plano> save(@Valid @RequestBody Plano plano) {
        Optional<Plano> opt = planoRepository.findById(plano.getId());
        if(opt.isPresent()) {
            return new ResponseEntity<Plano>(HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<Plano>(planoRepository.save(plano), HttpStatus.CREATED);
        }
    }

    // Método Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Plano> update(@Valid @PathVariable long id, @RequestBody Plano plano) {
        Optional<Plano> opt = planoRepository.findById(id);
        if (opt.isPresent()) {
            Plano planoAux = opt.get();
            planoAux.setNome(plano.getNome());
            planoAux.setValorPorMinuto(plano.getValorPorMinuto());
            return new ResponseEntity<Plano>(planoRepository.save(planoAux), HttpStatus.OK);
        } else {
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
    }

    // Método Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Plano> delete(@PathVariable long id) {
        try {
            planoRepository.deleteById(id);
            return new ResponseEntity<Plano>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
    }
}
