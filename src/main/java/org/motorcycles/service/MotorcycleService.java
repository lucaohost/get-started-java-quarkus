package org.motorcycles.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.motorcycles.model.Motorcycle;
import org.motorcycles.repository.MotorcycleRepository;
@ApplicationScoped
public class MotorcycleService {

    @Inject
    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
        return motorcycleRepository.saveMotorcycle(motorcycle);
    }

}
