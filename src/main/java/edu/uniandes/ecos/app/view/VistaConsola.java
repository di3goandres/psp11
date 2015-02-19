/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.app.view;

import edu.uniandes.ecos.app.model.CalculoTamanoRelativo;
import edu.uniandes.ecos.app.model.DesviacionEstandar;
import edu.uniandes.ecos.app.model.RangoTamanoRelativo;


import java.util.AbstractList;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author COCO
 */
public class VistaConsola {

    public static void main(String[] args) {

        test1();

    }

    public static void test1() {

        List<Double> numeros = new LinkedList<Double>();
        List<Double> numerosLN = new LinkedList<Double>();
        numeros.add(6.0000);
        numeros.add(6.0000);
        numeros.add(8.3333);
        numeros.add(10.3333);
        numeros.add(12.3333);
        numeros.add(16.4000);
        numeros.add(20.5000);
        numeros.add(21.7500);
        numeros.add(22.2500);
        numeros.add(23.0000);
        numeros.add(28.3333);
        numeros.add(29.0000);
        numeros.add(55.8000);

        CalculoTamanoRelativo c = new CalculoTamanoRelativo();
        DesviacionEstandar desv = new DesviacionEstandar();

        CalculoTamanoRelativo d = new CalculoTamanoRelativo();

        numerosLN = d.ConvertirALN(numeros);
        desv.DesviacionEstandarAdd(numerosLN);
        double valorPromedio = desv.MediaAritmetica();

        RangoTamanoRelativo dat = c.obtenerRangoTamanioRelativo(numeros);

        System.out.println("VS:" + dat.getVerySmall());
        System.out.println("S:" + dat.getSmall());

        System.out.println("M:" + dat.getMedium());

        System.out.println("L:" + dat.getLarge());
        System.out.println("VL:" + dat.getVeryLarge());

    }

}
