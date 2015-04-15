package ru.kidstat.dao;

import org.springframework.stereotype.Repository;
import ru.kidstat.model.Measure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by darya on 09/04/15.
 */

@Repository("measureDAO")
public class MeasureDAOImpl implements MeasureDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Measure save(Measure measure) {
        em.persist(measure);
        em.flush();
        return measure;
    }

    @Override
    public List<Measure> getMeasures() {
        return em.createQuery("SELECT m FROM measure m").getResultList();
    }
}
