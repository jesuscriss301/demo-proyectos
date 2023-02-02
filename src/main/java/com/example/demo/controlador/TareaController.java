package com.example.demo.controlador;

import com.example.demo.modelo.Tarea;
import com.example.demo.vista.TareaRepository;
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
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    TareaRepository tareaRepository;


    @GetMapping
    public List<Tarea> getTareaAll() {
        return tareaRepository.findAll();
    }


    @GetMapping("/{id}")
    public Tarea getTareabyId(@PathVariable int id) {

        Optional<Tarea> tarea = tareaRepository.findById(id);

        if (tarea.isPresent()) {
            return tarea.get();
        }

        return null;
    }


    @PostMapping
    public Tarea postTarea(@RequestBody Tarea tarea) {
        tareaRepository.save(tarea);
        return tarea;
    }


    @PutMapping("/{id}")
    public Tarea putTareabyId(@PathVariable int id, @RequestBody Tarea tarea) {

        Optional<Tarea> tareaCurrent = tareaRepository.findById(id);

        if (tareaCurrent.isPresent()) {
            Tarea tareaReturn = tareaCurrent.get();

            tareaReturn.setNombreTarea(tarea.getNombreTarea());
            tareaReturn.setDescripcionTarea(tarea.getDescripcionTarea());
            tareaReturn.setIdEtapa(tarea.getIdEtapa());
            tareaReturn.setFecha(tarea.getFecha());
            tareaReturn.setCompletado(tarea.getCompletado());
            tareaReturn.setBitacoras(tarea.getBitacoras());

            tareaRepository.save(tareaReturn);
            return tareaReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Tarea deleteTareabyId(@PathVariable int id) {

        Optional<Tarea> tarea = tareaRepository.findById(id);

        if (tarea.isPresent()) {
            Tarea tareaReturn = tarea.get();
            tareaRepository.deleteById(id);
            return tareaReturn;
        }

        return null;
    }
}
