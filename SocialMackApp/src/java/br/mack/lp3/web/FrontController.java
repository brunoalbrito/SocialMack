package br.mack.lp3.web;

import br.mack.lp3.controller.Controller;
import br.mack.lp3.controller.ControllerFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1147106
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ctrl = request.getParameter("ctrl");
        
        Controller controller = ControllerFactory.getInstanceByName(ctrl);
        
        String page = "erro.jsp";
        if(controller!=null){
            controller.init(request, response);
            controller.execute();
            page = controller.getReturnPage();
        }
        
        response.sendRedirect(page);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
