package org.motorcycles.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.motorcycles.model.Motorcycle;
import org.motorcycles.repository.MotorcyclesRepository;

import java.util.List;

@ApplicationScoped
public class MotorcyclesService {

    @Inject
    private MotorcyclesRepository motorcyclesRepository;

    public MotorcyclesService(MotorcyclesRepository motorcyclesRepository) {
        this.motorcyclesRepository = motorcyclesRepository;
    }

    public Motorcycle save(Motorcycle motorcycle) {
        return motorcyclesRepository.save(motorcycle);
    }

    public List<Motorcycle> getAll() {
        return motorcyclesRepository.getAll();
    }

    public Motorcycle getById(Long id) {
        return motorcyclesRepository.get(id);
    }

    public Motorcycle update(Long id, Motorcycle motorcycle) {
        return motorcyclesRepository.update(id, motorcycle);
    }

    public void delete(Long id) {
        motorcyclesRepository.delete(id);

    }
}
