package br.mack.lp3.controller.impl;

import br.mack.lp3.controller.AbstractController;
import br.mack.lp3.persistence.ParticipanteDAO;
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
public class AlterarController extends AbstractController {

    ParticipanteDAO participanteDAO = lookupParticipanteDAOBean();

    @Override
    public void execute() {
        try {
            System.out.println("FUNCIONOU");
            String name = this.getRequest().getParameter("name");
            String email = this.getRequest().getParameter("email");

            Participante participante = (Participante) getRequest().getSession().getAttribute("participante");
            participante.setNome(name);
            participante.setEmail(email);

            try {
                participanteDAO.update(participante);
            } catch (Exception ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }

            getRequest().getSession().setAttribute("participante", participante);

            System.out.println(name + " - " + email);
            this.setReturnPage("sucesso.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AlterarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ParticipanteDAO lookupParticipanteDAOBean() {
        try {
            Context c = new InitialContext();
            return (ParticipanteDAO) c.lookup("java:global/SocialMack/ParticipanteDAO!br.mack.lp3.persistence.ParticipanteDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
