package org.motorcycles.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.motorcycles.model.Motorcycle;

import java.util.List;

@ApplicationScoped
public class MotorcyclesRepositoryImpl implements MotorcyclesRepository {

    @Inject
    private EntityManager em;

    @Override
    @Transactional
    public Motorcycle save(Motorcycle motorcycle) {
        em.persist(motorcycle);
        return motorcycle;
    }

    @Override
    @Transactional
    public Motorcycle update(Long id, Motorcycle updatedMotorcycle) {
        Motorcycle motorcycle = em.find(Motorcycle.class, id);
        if (motorcycle != null) {
            motorcycle.setCv(updatedMotorcycle.getCv());
            motorcycle.setYear(updatedMotorcycle.getYear());
            motorcycle.setTorque(updatedMotorcycle.getTorque());
            motorcycle.setModel(updatedMotorcycle.getModel());
            motorcycle.setBrand(updatedMotorcycle.getBrand());
            motorcycle.setAdditionalInfo(updatedMotorcycle.getAdditionalInfo());
            em.merge(motorcycle);
        }
        return motorcycle;
    }

    @Override
    public List<Motorcycle> getAll() {
        TypedQuery<Motorcycle> query = em.createNamedQuery("Motorcycle.findAll", Motorcycle.class);
        return query.getResultList();
    }

    @Override
    public Motorcycle get(Long id) {
        return em.find(Motorcycle.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Motorcycle motorcycle = em.find(Motorcycle.class, id);
        if (motorcycle != null) {
            em.remove(motorcycle);
        }
    }

}
