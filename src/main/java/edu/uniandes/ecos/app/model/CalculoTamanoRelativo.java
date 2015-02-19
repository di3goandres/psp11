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
    
        
        double VS = Math.exp(valorPromedio - (2 * desviacionEstandar));

        double S = Math.exp(valorPromedio - (desviacionEstandar));
        double M = Math.exp(valorPromedio);

        double L = Math.exp(valorPromedio + (desviacionEstandar));

        double VL = Math.exp(valorPromedio + (2 * desviacionEstandar));

        return new RangoTamanoRelativo(VS, S, M, L, VL);

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
