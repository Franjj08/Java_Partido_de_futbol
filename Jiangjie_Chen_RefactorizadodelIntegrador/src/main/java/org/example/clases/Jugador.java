package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Jugador {
    private Equipo equipoSelecionado;
    private int puntaje;

    public Jugador() {
    }

    public Jugador(Equipo equipoSelecionado, int puntaje) {
        this.equipoSelecionado = equipoSelecionado;
        this.puntaje = puntaje;
    }

    public Equipo getEquipoSelecionado() {
        return equipoSelecionado;
    }

    public void setEquipoSelecionado(Equipo equipoSelecionado) {
        this.equipoSelecionado = equipoSelecionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void elegirEquipo(List<Equipo> listaEquipos){
        String listaDeLosEquiposEnMensaje = "Equipos: \n";
        for(int i=0; i<listaEquipos.size();i++){
            listaDeLosEquiposEnMensaje+=(i+1)+". "+listaEquipos.get(i).getNombre()+"\n";
        }
        JOptionPane.showMessageDialog(null,listaDeLosEquiposEnMensaje,"Seleccion de equipo",JOptionPane.INFORMATION_MESSAGE);

        int indiceEquipo = 0;
        do{
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice del equipo que quiere seleccionar","Ingrese valor",JOptionPane.INFORMATION_MESSAGE))-1;
        }while (indiceEquipo <1 || indiceEquipo >8);

        JOptionPane.showMessageDialog(null,"EL EQUIPO QUE ELEGISTE ES: "+listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSelecionado = listaEquipos.get(indiceEquipo);
    }
    public void sumarPuntos(){
        if(equipoSelecionado.isAutorizacion()){
            puntaje++;
        }
    }
}
