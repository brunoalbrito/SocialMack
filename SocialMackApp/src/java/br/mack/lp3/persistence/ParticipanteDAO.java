package br.mack.lp3.persistence;

import br.mack.lp3.persistence.entities.Participante;
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
public class ParticipanteDAO implements GenericDAO<Participante> {
    
    @PersistenceContext(unitName = "SocialMackPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    @Override
    public void create(Participante participante) throws Exception {
        em.persist(participante);
    }
    
    @Override
    public List<Participante> readAll() throws Exception {
        Query q = em.createQuery("SELECT p FROM Participante p");
        List<Participante> lista = q.getResultList();
        return lista;
    }
    
    @Override
    public Participante readById(long id) throws Exception {
        
        return em.find(Participante.class, id); //EAGER
//        return em.getReference(Participante.class, id) //LAZY
    }
    
    @Override
    public void update(Participante participante) throws Exception {
        em.persist(em.merge(participante));
    }
    
    @Override
    public void delete(Participante participante) throws Exception {
        em.remove(em.merge(participante));
    }

    public List<Participante> readById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
