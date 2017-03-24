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
import br.mack.lp3.persistence.entities.Participante;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class RegistrarPalestraController extends AbstractController {

    PalestraDAO palestraDAO = lookupPalestraDAOBean();

    ParticipanteDAO participanteDAO = lookupParticipanteDAOBean();
    

    
    @Override
    public void execute() {
        Participante participante = (Participante) getRequest().getSession().getAttribute("participante");
        long id = participante.getId_participante();
        
        try {
            participante = participanteDAO.readById(id);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long id_palestra = Long.parseLong(getRequest().getParameter("idPalestra"));
        try {
            Palestra p = palestraDAO.readById(id_palestra);
            p.addParticipante(participante);
            palestraDAO.update(p);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPalestraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setReturnPage("sucesso.jsp");
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

    private PalestraDAO lookupPalestraDAOBean() {
        try {
            Context c = new InitialContext();
            return (PalestraDAO) c.lookup("java:global/SocialMackApp/PalestraDAO!br.mack.lp3.persistence.PalestraDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
