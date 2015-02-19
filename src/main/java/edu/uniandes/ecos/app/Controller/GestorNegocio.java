/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.app.Controller;

import edu.uniandes.ecos.app.model.CalculoTamanoRelativo;
import edu.uniandes.ecos.app.model.RangoTamanoRelativo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author COCO
 */
public class GestorNegocio {

    public RangoTamanoRelativo GestorNegocio(List<Double> datosCalculos) {

        CalculoTamanoRelativo calculoTamanio = new CalculoTamanoRelativo();
        RangoTamanoRelativo datoretorno = calculoTamanio.obtenerRangoTamañoRelativo(datosCalculos);
        return datoretorno;

    }

    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>Taller No 4 - PSP1.1</h1>");
        pw.println("<p>ECOS 2015 <br>Diego Andres Montealegre Garcia</p>");
        pw.write("<html>");
        pw.println("Ingrese la cadena de datos de prueba");
        pw.println("<br>Separar los datos con el pipe '|' ");
        pw.println("<br>los decimales con punto (10.9), no con coma<br>");
        pw.write("<form action=\"calc\" method=\"post\">"
                + "<table>"
                + "<tr><td>Cadena de valores</td><td><textarea rows=\"4\" cols=\"190\" name=\"lst1\"></textarea></td></tr>"
                + "</table> <input type=\"submit\" value=\"realizar calculos\">"
                + "</form> ");
        pw.println("<h2></h2>");
        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp,
            RangoTamanoRelativo resultado)
            throws ServletException, IOException {

        resp.getWriter().println("<h2>Resultados</h2>");
        resp.getWriter().println("VS: " + resultado.getVerySmall() + "<br>");
        resp.getWriter().println("S : " + resultado.getSmall() + "<br>");
        resp.getWriter().println("M : " + resultado.getMedium() + "<br>");
        resp.getWriter().println("L : " + resultado.getLarge() + "<br>");
        resp.getWriter().println("VL: " + resultado.getVeryLarge() + "<br>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<h2>Test Realizados</h2>");
        resp.getWriter().println("<b>Lista LOC/Method: <br></b>"
                + "6.0000|6.0000|8.3333|10.3333|12.3333|16.4000|20.5000|21.7500|22.2500|23.0000|28.3333|29.0000|55.8000<br>");
        resp.getWriter().println("<b>Lista Pgs/Chapter: <br></b>"
                + "7|12|10|12|10|12|12|12|12|8|8|8|20|14|18|12<br>");

    }

    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }

}
