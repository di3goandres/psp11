/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.app.model;

import edu.uniandes.ecos.app.model.DesviacionEstandar;
import edu.uniandes.ecos.app.model.RangoTamanoRelativo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author COCO
 */
public class CalculoTamanoRelativo {

    private List<Double> numerosLN = new LinkedList<Double>();

    public RangoTamanoRelativo obtenerRangoTamanioRelativo(
            List<Double> listaNumeros) {

        DesviacionEstandar desv = new DesviacionEstandar();
        ConvertirALN(listaNumeros);
        desv.DesviacionEstandarAdd(numerosLN);
        double valorPromedio = desv.MediaAritmetica();
        double desviacionEstandar = (desv.DesviacionStandard());
        double verySmall = Math.exp(valorPromedio - (2 * desviacionEstandar));
        double small = Math.exp(valorPromedio - (desviacionEstandar));
        double medium = Math.exp(valorPromedio);
        double large = Math.exp(valorPromedio + (desviacionEstandar));
        double verylarge = Math.exp(valorPromedio + (2 * desviacionEstandar));
        return new RangoTamanoRelativo(verySmall, small, medium, large, verylarge);

    }

    public List<Double> ConvertirALN(List<Double> numerosP) {
        Double log = 0D;
        for (Double num : numerosP) {
            log = Math.log(num);
            numerosLN.add(log);
        }
        return numerosLN;

    }
}
