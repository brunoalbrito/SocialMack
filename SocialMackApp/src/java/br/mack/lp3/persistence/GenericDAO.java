package br.mack.lp3.persistence;

import java.util.List;

/**
 *
 * @author 41583469
 */
public interface GenericDAO<E> {
    public void create(E e)throws Exception;
    
    public List<E> readAll()throws Exception; 
    public E readById(long id)throws Exception; 
    
    public void update(E e)throws Exception;
    
    public void delete(E e)throws Exception;
    
    
}
