package edu.uniandes.ecos.app.view;

import edu.uniandes.ecos.app.Controller.GestorNegocio;
import edu.uniandes.ecos.app.model.RangoTamanoRelativo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 * Hello world!
 *
 */
public class App extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RangoTamanoRelativo datos = new RangoTamanoRelativo(0, 0, 0, 0, 0);
        GestorNegocio.showHome(req, resp);
        GestorNegocio.showResults(req, resp, datos);

    }

    public void consoleInput(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String calc = req.getParameter("lst1");
        GestorNegocio gestorNegocio = new GestorNegocio();
        List<Double> listaDeNumeros = new LinkedList<Double>();
        String[] pares = calc.split("\\|");
        Double nextElement = 0D;

        for (int i = 0; i < pares.length; i++) {
            try {
                nextElement = Double.valueOf(pares[i]);
                listaDeNumeros.add(nextElement);

            } catch (NumberFormatException ex) {
                GestorNegocio.error(req, resp);
            }
        }

        RangoTamanoRelativo resultado = gestorNegocio.GestorNegocio(listaDeNumeros);
        gestorNegocio.showResults(req, resp, resultado);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        server.start();
        server.join();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            GestorNegocio.showHome(req, resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
