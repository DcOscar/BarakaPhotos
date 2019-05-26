/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import java.util.*;

/**
 *
 * @author Oscar
 */
public class GestionadorClub {

    private ArrayList<Boxeadora> grupoAzul;
    private ArrayList<Boxeadora> grupoDorado;

    public GestionadorClub() {
        this.grupoAzul = new ArrayList<Boxeadora>();
        this.grupoDorado = new ArrayList<Boxeadora>();
    }

    public void agregarBoxeadoraGrupoAzul(double altura) {
        if (altura > 0) {
            this.grupoAzul.add(new Boxeadora(altura));
        }
    }

    public void agregarBoxeadoraGrupoDorado(double altura) {
        if (altura > 0) {
            this.grupoDorado.add(new Boxeadora(altura));
        }
    }

    public ArrayList<Boxeadora> getGrupoAzul() {
        return grupoAzul;
    }

    public ArrayList<Boxeadora> getGrupoDorado() {
        return grupoDorado;
    }

    private double compararAltura() {
        double comparacionAltura;
        ArrayList<Double> comparadorAlturas = new ArrayList<Double>();
        for (int j = 0; j < this.grupoDorado.size(); j++) {
            comparacionAltura = this.grupoAzul.get(0).getAltura() - this.grupoDorado.get(j).getAltura();
            if (comparacionAltura > 0) {
                comparadorAlturas.add(comparacionAltura);
            }
        }
        if (comparadorAlturas.size() > 0) {
            Collections.sort(comparadorAlturas);
            return comparadorAlturas.get(0);
        } else {
            return -1;
        }
    }

    private boolean verificadorComparadorAltura(double comparador) {
        double comparacionAltura;
        if (comparador == -1) {
            return false;
        }
        for (int k = 0; k < this.grupoDorado.size(); k++) {
            comparacionAltura = this.grupoAzul.get(0).getAltura() - comparador;
            if (this.grupoDorado.get(k).getAltura() == comparacionAltura) {
                this.grupoAzul.remove(0);
                this.grupoDorado.remove(k);
                return true;
            }
        }
        return false;
    }

    public String ordenarBoxeadoras() {
        double comparacionAltura;
        boolean condicion = true;
        if (this.grupoAzul.size() != this.grupoDorado.size()) {
            return "No";
        }
        while (condicion) {
            if (this.grupoAzul.isEmpty() && this.grupoDorado.isEmpty()) {
                break;
            }
            condicion = this.verificadorComparadorAltura(this.compararAltura());

        }

        if (this.grupoAzul.isEmpty() && this.grupoDorado.isEmpty()) {
            return "Yes";
        }
        return "No";
    }

    public void mostrarGrupoAzul() {
        String a = "";
        for (int i = 0; i < this.grupoAzul.size(); i++) {
            a += String.valueOf(this.grupoAzul.get(i).getAltura()) + " ";
        }
        System.out.println(a);
    }

    public void mostrarGrupoDorado() {
        String a = "";
        for (int i = 0; i < this.grupoDorado.size(); i++) {
            a += String.valueOf(this.grupoDorado.get(i).getAltura()) + " ";
        }
        System.out.println(a);
    }
}
