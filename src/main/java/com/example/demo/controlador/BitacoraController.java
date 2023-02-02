package com.example.demo.controlador;

import com.example.demo.modelo.Bitacora;
import com.example.demo.vista.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bitacoras")
public class BitacoraController {

    @Autowired
    BitacoraRepository bitacoraRepository;


    @GetMapping
    public List<Bitacora> getBitacoraAll() {
        return bitacoraRepository.findAll();
    }


    @GetMapping("/{id}")
    public Bitacora getBitacorabyId(@PathVariable int id) {

        Optional<Bitacora> bitacora = bitacoraRepository.findById(id);

        if (bitacora.isPresent()) {
            return bitacora.get();
        }

        return null;
    }


    @PostMapping
    public Bitacora postBitacora(@RequestBody Bitacora bitacora) {
        bitacoraRepository.save(bitacora);
        return bitacora;
    }


    @PutMapping("/{id}")
    public Bitacora putBitacorabyId(@PathVariable int id, @RequestBody Bitacora bitacora) {

        Optional<Bitacora> bitacoraCurrent = bitacoraRepository.findById(id);

        if (bitacoraCurrent.isPresent()) {
            Bitacora bitacoraReturn = bitacoraCurrent.get();

            bitacoraReturn.setDescripcionBitacora(bitacora.getDescripcionBitacora());
            bitacoraReturn.setFecha(bitacora.getFecha());
            bitacoraReturn.setIdFoto(bitacora.getIdFoto());

            bitacoraRepository.save(bitacoraReturn);
            return bitacoraReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Bitacora deleteBitacorabyId(@PathVariable int id) {

        Optional<Bitacora> bitacora = bitacoraRepository.findById(id);

        if (bitacora.isPresent()) {
            Bitacora bitacoraReturn = bitacora.get();
            bitacoraRepository.deleteById(id);
            return bitacoraReturn;
        }

        return null;
    }
}

