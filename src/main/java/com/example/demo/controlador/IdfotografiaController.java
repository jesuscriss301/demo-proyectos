package com.example.demo.controlador;

import com.example.demo.modelo.Idfotografia;
import com.example.demo.vista.IdfotografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/idfotografias")
public class IdfotografiaController {

    @Autowired
    IdfotografiaRepository idfotografiaRepository;


    @GetMapping
    public List<Idfotografia> getIdfotografiaAll() {
        return idfotografiaRepository.findAll();
    }


    @GetMapping("/{id}")
    public Idfotografia getIdfotografiabyId(@PathVariable int id) {

        Optional<Idfotografia> idfotografia = idfotografiaRepository.findById(id);

        if (idfotografia.isPresent()) {
            return idfotografia.get();
        }

        return null;
    }


    @PostMapping
    public Idfotografia postIdfotografia(@RequestBody Idfotografia idfotografia) {
        idfotografiaRepository.save(idfotografia);
        return idfotografia;
    }


    @PutMapping("/{id}")
    public Idfotografia putIdfotografiabyId(@PathVariable int id, @RequestBody Idfotografia idfotografia) {

        Optional<Idfotografia> idfotografiaCurrent = idfotografiaRepository.findById(id);

        if (idfotografiaCurrent.isPresent()) {
            Idfotografia idfotografiaReturn = idfotografiaCurrent.get();

            idfotografiaReturn.setNombreFoto(idfotografia.getNombreFoto());
            idfotografiaReturn.setDireccionCarpeta(idfotografia.getDireccionCarpeta());
            idfotografiaReturn.setFecha(idfotografia.getFecha());

            idfotografiaRepository.save(idfotografiaReturn);
            return idfotografiaReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Idfotografia deleteIdfotografiabyId(@PathVariable int id) {

        Optional<Idfotografia> idfotografia = idfotografiaRepository.findById(id);

        if (idfotografia.isPresent()) {
            Idfotografia idfotografiaReturn = idfotografia.get();
            idfotografiaRepository.deleteById(id);
            return idfotografiaReturn;
        }

        return null;
    }
}

