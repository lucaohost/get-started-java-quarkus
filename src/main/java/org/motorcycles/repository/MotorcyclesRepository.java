package org.motorcycles.repository;

import org.motorcycles.model.Motorcycle;

import java.util.List;

public interface MotorcyclesRepository {

    public Motorcycle save(Motorcycle motorcycle);

    public Motorcycle update(Long id, Motorcycle motorcycle);

    public List<Motorcycle> getAll();

    public Motorcycle get(Long id);

    public void delete(Long id);

    public Long count();

}
