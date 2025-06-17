package com.example.services;

import com.example.models.Pabellon;
import com.example.repository.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PabellonServices {

    @Autowired
    private PabellonRepository pabellonRepository;

    // Obtener todos los pabellones
    public List<Pabellon> getAll() {
        return pabellonRepository.findAll();
    }

    // Obtener un pabellón por su ID
    public Pabellon getById(Integer id) {
        return pabellonRepository.findById(id).orElse(null);
    }

    // Crear un nuevo pabellón
    public Pabellon add(Pabellon pabellon) {
        if (pabellon.getIdPabellon() != null && pabellonRepository.existsById(pabellon.getIdPabellon())) {
            return null;
        }
        return pabellonRepository.save(pabellon);
    }

    // Actualizar un pabellón existente
    public Pabellon update(Pabellon pabellon) {
        if (pabellon.getIdPabellon() == null || !pabellonRepository.existsById(pabellon.getIdPabellon())) {
            return null;
        }
        return pabellonRepository.save(pabellon);
    }
}
