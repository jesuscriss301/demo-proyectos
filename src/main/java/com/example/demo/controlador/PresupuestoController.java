package com.example.demo.controlador;

import com.example.demo.modelo.Presupuesto;
import com.example.demo.vista.PresupuestoRepository;
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
@RequestMapping("/presupuestos")
public class PresupuestoController {

    @Autowired
    PresupuestoRepository presupuestoRepository;


    @GetMapping
    public List<Presupuesto> getPresupuestoAll() {
        return presupuestoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Presupuesto getPresupuestobyId(@PathVariable int id) {

        Optional<Presupuesto> presupuesto = presupuestoRepository.findById(id);

        if (presupuesto.isPresent()) {
            return presupuesto.get();
        }

        return null;
    }


    @PostMapping
    public Presupuesto postPresupuesto(@RequestBody Presupuesto presupuesto) {
        presupuestoRepository.save(presupuesto);
        return presupuesto;
    }


    @PutMapping("/{id}")
    public Presupuesto putPresupuestobyId(@PathVariable int id, @RequestBody Presupuesto presupuesto) {

        Optional<Presupuesto> presupuestoCurrent = presupuestoRepository.findById(id);

        if (presupuestoCurrent.isPresent()) {
            Presupuesto presupuestoReturn = presupuestoCurrent.get();

            presupuestoReturn.setCotizacion(presupuesto.getCotizacion());
            presupuestoReturn.setFecha(presupuesto.getFecha());
            presupuestoReturn.setPersonal(presupuesto.getPersonal());
            presupuestoReturn.setMaterial(presupuesto.getMaterial());

            presupuestoRepository.save(presupuestoReturn);
            return presupuestoReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Presupuesto deletePresupuestobyId(@PathVariable int id) {

        Optional<Presupuesto> presupuesto = presupuestoRepository.findById(id);

        if (presupuesto.isPresent()) {
            Presupuesto presupuestoReturn = presupuesto.get();
            presupuestoRepository.deleteById(id);
            return presupuestoReturn;
        }

        return null;
    }
}

