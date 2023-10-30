package org.motorcycles.repository;

import org.motorcycles.model.Motorcycle;

import java.util.List;

public interface MotorcyclesRepository {

    public Motorcycle save(Motorcycle motorcycle);

    public Motorcycle updateMotorcycle(Long id, Motorcycle motorcycle);

    public List<Motorcycle> getAll();

    public Motorcycle get(Long id);

    void delete(Long id);
}
