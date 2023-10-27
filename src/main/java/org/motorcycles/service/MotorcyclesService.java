package org.motorcycles.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.motorcycles.model.Motorcycle;
import org.motorcycles.repository.MotorcyclesRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MotorcyclesService {

    @Inject
    private MotorcyclesRepository motorcyclesRepository;

    public MotorcyclesService(MotorcyclesRepository motorcyclesRepository) {
        this.motorcyclesRepository = motorcyclesRepository;
    }

    public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
        return motorcyclesRepository.saveMotorcycle(motorcycle);
    }

    public List<Motorcycle> getAll() {
        return motorcyclesRepository.getAll();
    }

}
