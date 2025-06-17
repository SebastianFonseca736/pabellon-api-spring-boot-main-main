package com.example.controllers;

import com.example.models.Pabellon;
import com.example.services.PabellonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pabellones")
public class PabellonController {

    @Autowired
    private PabellonServices pabellonServices;

    // POST /api/v1/pabellones
    @PostMapping
    public ResponseEntity<Pabellon> addPabellon(@RequestBody Pabellon pabellon) {
        Pabellon nuevoPabellon = pabellonServices.add(pabellon);
        if (nuevoPabellon == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(nuevoPabellon);
    }

    // GET /api/v1/pabellones
    @GetMapping
    public ResponseEntity<List<Pabellon>> getAllPabellones() {
        List<Pabellon> pabellones = pabellonServices.getAll();
        return ResponseEntity.ok(pabellones);
    }

    // GET /api/v1/pabellones/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Pabellon> getPabellonById(@PathVariable Integer id) {
        Pabellon pabellon = pabellonServices.getById(id);
        if (pabellon == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pabellon);
    }

    // PUT /api/v1/pabellones
    @PutMapping
    public ResponseEntity<Pabellon> updatePabellon(@RequestBody Pabellon pabellon) {
        Pabellon actualizado = pabellonServices.update(pabellon);
        if (actualizado == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(actualizado);
    }
}
