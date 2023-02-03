package com.example.demo.controlador;

import com.example.demo.modelo.Diseño;
import com.example.demo.vista.DisenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/planos")
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

            diseñoReturn.setNombreDiseño(diseño.getNombreDiseño());
            diseñoReturn.setDireccionCarpeta(diseño.getDireccionCarpeta());
            diseñoReturn.setFechaDiseño(diseño.getFechaDiseño());
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
