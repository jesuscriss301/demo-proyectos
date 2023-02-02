package com.example.demo.controlador;

import com.example.demo.modelo.Etapa;
import com.example.demo.vista.EtapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/etapas")
public class EtapaController {

    @Autowired
    EtapaRepository etapaRepository;


    @GetMapping
    public List<Etapa> getEtapaAll() {
        return etapaRepository.findAll();
    }


    @GetMapping("/{id}")
    public Etapa getEtapabyId(@PathVariable int id) {

        Optional<Etapa> etapa = etapaRepository.findById(id);

        if (etapa.isPresent()) {
            return etapa.get();
        }

        return null;
    }


    @PostMapping
    public Etapa postEtapa(@RequestBody Etapa etapa) {
        etapaRepository.save(etapa);
        return etapa;
    }


    @PutMapping("/{id}")
    public Etapa putEtapabyId(@PathVariable int id, @RequestBody Etapa etapa) {

        Optional<Etapa> etapaCurrent = etapaRepository.findById(id);

        if (etapaCurrent.isPresent()) {
            Etapa etapaReturn = etapaCurrent.get();

            etapaReturn.setNombreEtapa(etapa.getNombreEtapa());

            etapaRepository.save(etapaReturn);
            return etapaReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Etapa deleteEtapabyId(@PathVariable int id) {

        Optional<Etapa> etapa = etapaRepository.findById(id);

        if (etapa.isPresent()) {
            Etapa etapaReturn = etapa.get();
            etapaRepository.deleteById(id);
            return etapaReturn;
        }

        return null;
    }
}

