package com.example.demo.controlador;

import com.example.demo.modelo.Diseño;
import com.example.demo.vista.DisenoRepository;
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
@RequestMapping("/diseños")
public class DiseñoController {

    @Autowired
    DisenoRepository diseñoRepository;


    @GetMapping
    public List<Diseño> getDiseñoAll() {
        return diseñoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Diseño getDiseñobyId(@PathVariable int id) {

        Optional<Diseño> diseño = diseñoRepository.findById(id);

        if (diseño.isPresent()) {
            return diseño.get();
        }

        return null;
    }


    @PostMapping
    public Diseño postDiseño(@RequestBody Diseño diseño) {
        diseñoRepository.save(diseño);
        return diseño;
    }


    @PutMapping("/{id}")
    public Diseño putDiseñobyId(@PathVariable int id, @RequestBody Diseño diseño) {

        Optional<Diseño> diseñoCurrent = diseñoRepository.findById(id);

        if (diseñoCurrent.isPresent()) {
            Diseño diseñoReturn = diseñoCurrent.get();

            diseñoReturn.setNombreDicseño(diseño.getNombreDicseño());
            diseñoReturn.setDireccionCarpeta(diseño.getDireccionCarpeta());
            diseñoReturn.setFechaDiceño(diseño.getFechaDiceño());
            diseñoReturn.setAprovado(diseño.getAprovado());

            diseñoRepository.save(diseñoReturn);
            return diseñoReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Diseño deleteDiseñobyId(@PathVariable int id) {

        Optional<Diseño> diseño = diseñoRepository.findById(id);

        if (diseño.isPresent()) {
            Diseño diseñoReturn = diseño.get();
            diseñoRepository.deleteById(id);
            return diseñoReturn;
        }

        return null;
    }
}
