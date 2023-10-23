package org.motorcycles.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.motorcycles.model.Motorcycle;

@ApplicationScoped
public class MotorcyclesRepositoryImpl implements MotorcyclesRepository {

    @Inject
    private EntityManager em;

    @Override
    @Transactional
    public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
        em.persist(motorcycle);
        return motorcycle;
    }

}
