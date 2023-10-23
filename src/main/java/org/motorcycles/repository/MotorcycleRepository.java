package org.motorcycles.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.motorcycles.model.Motorcycle;

public interface MotorcycleRepository {

    public Motorcycle saveMotorcycle(Motorcycle motorcycle);

}
