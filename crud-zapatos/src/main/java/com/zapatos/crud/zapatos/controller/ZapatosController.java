package com.zapatos.crud.zapatos.controller;
import com.zapatos.crud.zapatos.model.Zapatos;
import com.zapatos.crud.zapatos.service.ZapatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zapateria")
public class ZapatosController {
    private final ZapatosService zapatosService;

    @Autowired
    public ZapatosController (ZapatosService zapatosService) {
        this.zapatosService = zapatosService;
    }

    @GetMapping
    public List<Zapatos> getAllZapatos() {
        return zapatosService.getZapatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zapatos> getZapatosById(@PathVariable Long id) {
        Optional<Zapatos> Zapatos = zapatosService.getZapatosById(id);
        return Zapatos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Zapatos createIceCream(@RequestBody Zapatos zapatos) {
        return zapatosService.createZapatos ( zapatos );
    }

    @PostMapping("/{id}")
    public ResponseEntity<Zapatos> updateIceCream(@PathVariable Long id, @RequestBody Zapatos zapatosDetails) {
        Optional<Zapatos> iceCream = zapatosService.updateZapatos (id, zapatosDetails );
        return iceCream.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZapatos(@PathVariable Long id) {
        if (zapatosService.deleteZapatos(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

