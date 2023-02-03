package com.example.demo.controlador;

import com.example.demo.modelo.Proyecto;
import com.example.demo.vista.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    ProyectoRepository proyectoRepository;


    @GetMapping
    public List<Proyecto> getProyectoAll() {
        return proyectoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Proyecto getProyectobyId(@PathVariable int id) {

        Optional<Proyecto> proyecto = proyectoRepository.findById(id);

        if (proyecto.isPresent()) {
            return proyecto.get();
        }

        return null;
    }


    @PostMapping
    public Proyecto postProyecto(@RequestBody Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        return proyecto;
    }


    @PutMapping("/{id}")
    public Proyecto putProyectobyId(@PathVariable int id, @RequestBody Proyecto proyecto) {

        Optional<Proyecto> proyectoCurrent = proyectoRepository.findById(id);

        if (proyectoCurrent.isPresent()) {
            Proyecto proyectoReturn = proyectoCurrent.get();

            proyectoReturn.setNombreProyecto(proyecto.getNombreProyecto());
            proyectoReturn.setDescripcionProyecto(proyecto.getDescripcionProyecto());
            proyectoReturn.setResponsable(proyecto.getResponsable());
            proyectoReturn.setAreaTerreno(proyecto.getAreaTerreno());
            proyectoReturn.setDiseno(proyecto.getDiseno());
            proyectoReturn.setPresupuesto(proyecto.getPresupuesto());

            proyectoRepository.save(proyectoReturn);
            return proyectoReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Proyecto deleteProyectobyId(@PathVariable int id) {

        Optional<Proyecto> proyecto = proyectoRepository.findById(id);

        if (proyecto.isPresent()) {
            Proyecto proyectoReturn = proyecto.get();
            proyectoRepository.deleteById(id);
            return proyectoReturn;
        }

        return null;
    }
}
