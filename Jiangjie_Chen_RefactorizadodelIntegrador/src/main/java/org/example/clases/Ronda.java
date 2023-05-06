package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Ronda {
    private int nroDeRonda;
    private  int cantidadDeEquiposEnRonda;
    private  int cantidadDeEquiposEnLlave;

    public Ronda() {
    }

    public Ronda(int nroDeROnda, int cantidadDeEquiposEnRonda, int cantidadDeEquiposEnLlave) {
        this.nroDeRonda = nroDeROnda;
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    public int getNroDeRonda() {
        return nroDeRonda;
    }

    public void setNroDeRonda(int nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposEnRonda;
    }

    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposEnRonda) {
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }

    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    public void cuartosDeFInal (Llave llaveIzquierda, Llave llaveDerecha){
        //Seteo el numero de ronda
        this.nroDeRonda =1 ;
        //Setea la cantidad de quipos en llave como 4
        this.cantidadDeEquiposEnLlave = 4;

        //Instancia un objeto de partido para usar su metodo
        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null,"Se jugaran los cuartos de final",
                "Cuartos",JOptionPane.INFORMATION_MESSAGE);

        //SImulo los partidos
        for (int i = 0; i < cantidadDeEquiposEnLlave; i+=2) {
            partido.simulaPartido(llaveIzquierda.getEquiposDeLaLlave().get(i),
                    llaveIzquierda.getEquiposDeLaLlave().get(i+1));
            partido.simulaPartido(llaveDerecha.getEquiposDeLaLlave().get(i),
                    llaveDerecha.getEquiposDeLaLlave().get(i+1));
        }
        //Remueve los que perdieron
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        //Setear la cantidad actual de equipos por llave
        this.cantidadDeEquiposEnLlave = 2;

    }
    public  void removerEquipos(List<Equipo> equipos) {
        int contadorEquiposPorLlave = cantidadDeEquiposEnLlave;
        for (int i = 0; i < contadorEquiposPorLlave; i++) {
            Equipo auxiliar = equipos.get(i);
            if (!auxiliar.isAutorizacion()){
                equipos.remove(auxiliar);
                contadorEquiposPorLlave--;
            }
        }
    }

    public  void semifinal (Llave llaveIzquierda, Llave llaveDerecha){
        //Seteo el numero de ronda
        this.nroDeRonda = 2;
        //Instancio un objeto de aprtido para usar su metodo
        Partido partido = new Partido();
        JOptionPane.showMessageDialog(null,"Se jugaran las semifinales",
                "Semifinal",JOptionPane.INFORMATION_MESSAGE);
        //Simular los partidos
        partido.simulaPartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveDerecha.getEquiposDeLaLlave().get(1));
        partido.simulaPartido(llaveIzquierda.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(1));
        //Removemos a los perdedores
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());

    }

    public  void finalDelTorneo (Llave llaveIzquierda, Llave llaveDerecha){
        //Seteo el numero de ronda
        this.nroDeRonda = 3;
        //Instancio un objeto de aprtido para usar su metodo
        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null,"Se jugara la final",
                "Final",JOptionPane.INFORMATION_MESSAGE);
        //Simular los partidos
        Equipo equipo = partido.simulaPartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(0));
        //Muestra un mensaje demostrando quien gano el torneo
        JOptionPane.showMessageDialog(null,"El ganador del torneo es: "+
                equipo.getNombre(),
                "Ganador del torneo",JOptionPane.INFORMATION_MESSAGE);

    }

}
