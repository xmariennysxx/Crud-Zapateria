package com.zapatos.crud.zapatos.service;

import com.zapatos.crud.zapatos.model.Zapatos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZapatosService {

    private List<Zapatos> zapatos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Zapatos> getZapatos() {
        return zapatos;
    }

    public Optional<Zapatos> getZapatosById(Long id) {
        return zapatos.stream().filter( zapatos -> zapatos.getId().equals(id)).findFirst();
    }

    public Zapatos createZapatos(Zapatos zapatos) {
        zapatos.setId(nextId++);
        this.zapatos.add( zapatos );
        return zapatos;
    }

    public Optional<Zapatos> updateZapatos(Long id, Zapatos zapatosDetails) {
        return getZapatosById(id).map( zapatos -> {
            zapatos.setModelo ( zapatosDetails.getModelo());
            zapatos.setModelo ( zapatosDetails.getModelo());
            zapatos.setTalla ( zapatosDetails.getTalla ());
            return zapatos;
        });
    }

    public boolean deleteZapatos(Long id) {
        return zapatos.removeIf( zapatos -> zapatos.getId().equals(id));
    }
}
