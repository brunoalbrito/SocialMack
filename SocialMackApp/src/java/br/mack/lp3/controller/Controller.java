package br.mack.lp3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1147106
 */
public interface Controller {
    public void init(HttpServletRequest request, HttpServletResponse response);
    public void execute();
    public String getReturnPage();
}
