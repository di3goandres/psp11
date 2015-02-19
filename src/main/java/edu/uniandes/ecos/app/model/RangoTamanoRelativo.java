/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.app.model;

/**
 *
 * @author COCO
 */
public class RangoTamanoRelativo {

    private double verySmall;
    private double small;
    private double medium;
    private double large;
    private double veryLarge;

    public RangoTamanoRelativo(double verySmall, double small, double medium,
            double large, double veryLarge) {

        this.verySmall = verySmall;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.veryLarge = veryLarge;
    }

    public double getVerySmall() {
        return verySmall;
    }

    public double getSmall() {
        return small;
    }

    public double getMedium() {
        return medium;
    }

    public double getLarge() {
        return large;
    }

    public double getVeryLarge() {
        return veryLarge;
    }
}
