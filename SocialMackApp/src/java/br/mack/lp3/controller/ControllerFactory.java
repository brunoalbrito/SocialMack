package br.mack.lp3.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1147106
 */
public class ControllerFactory {

    public static Controller getInstanceByName(String name) {
        Controller instance = null;
        
        System.out.println("**************** " + name + " ****************************");
        
        String className = "br.mack.lp3.controller.impl." + name + "Controller";
        try {
            instance = (Controller)Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return instance;
    }
}
