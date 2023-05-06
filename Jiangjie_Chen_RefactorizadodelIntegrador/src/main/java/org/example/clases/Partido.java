package org.example.clases;

import org.example.enumeraciones.Resultado;

import javax.swing.*;

public class Partido {
    private  int golesEquipoLocal = 2;
    private int getGolesEquipoVisitante = 3;

    public Partido() {
    }

    public Partido(int golesEquipoLocal, int getGolesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.getGolesEquipoVisitante = getGolesEquipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGetGolesEquipoVisitante() {
        return getGolesEquipoVisitante;
    }

    public void setGetGolesEquipoVisitante(int getGolesEquipoVisitante) {
        this.getGolesEquipoVisitante = getGolesEquipoVisitante;
    }

    public  Equipo simulaPartido(Equipo equipoLocal, Equipo equipoVisitante) {

        //Muestra un mensaje con el resultado del partido
        JOptionPane.showMessageDialog(null,equipoLocal.getNombre()+" "+
                this.golesEquipoLocal+ " - "+this.getGolesEquipoVisitante+" "+equipoVisitante.getNombre(),
                "Resultado",JOptionPane.INFORMATION_MESSAGE);

        //Le suma los goles a los equipos
        equipoLocal.sumaGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumaGolesNuevos(this.getGolesEquipoVisitante);

        //Logica del partido
        if(this.golesEquipoLocal > this.getGolesEquipoVisitante){
             equipoVisitante.setAutorizacion(false);
             equipoVisitante.setResultadoEnElTorneo(Resultado.PERDEDOR);
             equipoLocal.setResultadoEnElTorneo(Resultado.GANADOR);
            JOptionPane.showMessageDialog(null,"Gano "+equipoLocal.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE);
        }else if(this.golesEquipoLocal == this.getGolesEquipoVisitante){
            JOptionPane.showMessageDialog(null,
                    "Se jugara el desempate entre "+equipoLocal.getNombre()+" - "+
                    equipoVisitante.getNombre(),"Resultado", JOptionPane.INFORMATION_MESSAGE);
            equipoLocal.setResultadoEnElTorneo(Resultado.EMPATE);
            equipoVisitante.setResultadoEnElTorneo(Resultado.GANADOR);
            simulaPartido(equipoLocal, equipoVisitante);
        }else {
            equipoLocal.setAutorizacion(false);
            equipoVisitante.setResultadoEnElTorneo(Resultado.PERDEDOR);
            equipoVisitante.setResultadoEnElTorneo(Resultado.GANADOR);

            return equipoVisitante;
        }
        return null;
    }

}
