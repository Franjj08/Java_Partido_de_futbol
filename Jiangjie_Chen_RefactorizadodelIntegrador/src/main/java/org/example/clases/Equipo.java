package org.example.clases;

import org.example.enumeraciones.Resultado;

public class Equipo {
    private String nombre;
    private  boolean autorizacion = true;

    private Resultado resultadoEnElTorneo;
    private  int cantGolesEnElTorneo;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, boolean autorizacion, Resultado resultadoEnElTorneo, int cantGolesEnElTorneo) {
        this.nombre = nombre;
        this.autorizacion = autorizacion;
        this.resultadoEnElTorneo = resultadoEnElTorneo;
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultadoEnElTorneo() {
        return resultadoEnElTorneo;
    }

    public void setResultadoEnElTorneo(Resultado resultadoEnElTorneo) {
        this.resultadoEnElTorneo = resultadoEnElTorneo;
    }

    public int getCantGolesEnElTorneo() {
        return cantGolesEnElTorneo;
    }

    public void setCantGolesEnElTorneo(int cantGolesEnElTorneo) {
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public void sumaGolesNuevos(int nuevosGoles) {
        this.cantGolesEnElTorneo = nuevosGoles;
    }

}
