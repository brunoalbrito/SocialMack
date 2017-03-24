/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.lp3.controller.impl;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.persistence.PalestraDAO;
import br.mack.lp3.persistence.ParticipanteDAO;
import br.mack.lp3.persistence.entities.Palestra;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class ListarPalestraController extends AbstractController {

    ParticipanteDAO participanteDAO = lookupParticipanteDAOBean();

    PalestraDAO palestraDAO = lookupPalestraDAOBean();
    

    @Override
    public void execute() {
        List<Palestra> palestras = null;
        setReturnPage("erro.jsp");
        try {
            palestras = palestraDAO.readAll();
//            for(Palestra palestra:palestras){
//                System.out.println(palestra);
//            }
            setReturnPage("palestras.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ListarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getRequest().getSession().setAttribute("palestras", palestras);
    }

    private PalestraDAO lookupPalestraDAOBean() {
        try {
            Context c = new InitialContext();
            return (PalestraDAO) c.lookup("java:global/SocialMackApp/PalestraDAO!br.mack.lp3.persistence.PalestraDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ParticipanteDAO lookupParticipanteDAOBean() {
        try {
            Context c = new InitialContext();
            return (ParticipanteDAO) c.lookup("java:global/SocialMackApp/ParticipanteDAO!br.mack.lp3.persistence.ParticipanteDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
