package org.motorcycles.repository;

import org.motorcycles.model.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public interface MotorcyclesRepository {

    public Motorcycle saveMotorcycle(Motorcycle motorcycle);

    public Motorcycle updateMotorcycle(Long id, Motorcycle motorcycle);

    public List<Motorcycle> getAll();

    public Motorcycle getById(Long id);

}
