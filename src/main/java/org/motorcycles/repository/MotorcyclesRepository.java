package org.motorcycles.repository;

import org.motorcycles.model.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public interface MotorcyclesRepository {

    public Motorcycle saveMotorcycle(Motorcycle motorcycle);

    public List<Motorcycle> getAll();

}
