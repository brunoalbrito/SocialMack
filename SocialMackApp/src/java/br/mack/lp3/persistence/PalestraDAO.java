/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.persistence;

import br.mack.lp3.persistence.entities.Palestra;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author 41583469
 */
@LocalBean
@Stateful
public class PalestraDAO implements GenericDAO<Palestra> {

    @PersistenceContext(unitName = "SocialMackAppPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(Palestra participante) throws Exception {
        em.persist(participante);
    }

    @Override
    public List<Palestra> readAll() throws Exception {
        Query q = em.createQuery("SELECT p FROM Palestra p");
        List<Palestra> lista = q.getResultList();
        return lista;
    }

    @Override
    public Palestra readById(long id) throws Exception {
        Palestra palestra = (Palestra) em.find(Palestra.class, id);
        return palestra;
    }

    @Override
    public void update(Palestra e) throws Exception {
        em.persist(em.merge(e));
    }

    @Override
    public void delete(Palestra e) throws Exception {
        em.remove(em.merge(e));
    }

}
