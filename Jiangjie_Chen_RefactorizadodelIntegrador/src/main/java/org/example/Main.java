package org.example;

import org.example.clases.Equipo;
import org.example.clases.Jugador;
import org.example.clases.Llave;
import org.example.clases.Ronda;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Bienvenidos");
        menu();
    }
    public static void mostrarOpciones(){
        JOptionPane.showMessageDialog(null,"Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "0. Salir","Opciones",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void menu() {
        JOptionPane.showMessageDialog(null, "Bienvenido al Menu\nSelecciona una de las siguientes opciones:");

        // Se inicializan las variables que se utilizarán durante la ejecución del programa.
        boolean salir = true;
        ArrayList <Equipo> listaDeEquipos = null;
        Jugador jugador = null;
        Llave llaveDerecha = null;
        Llave llaveIzquierda = null;
        Ronda ronda = null;
        String opcion="";

        do {
            mostrarOpciones();
            // Se utiliza la función mostrarOpciones() para mostrar las opciones disponibles.
            opcion=JOptionPane.showInputDialog(null,"Ingrese la opcion: ",
                    "Ingreso opcion",JOptionPane.INFORMATION_MESSAGE);
            switch (opcion) {
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo", "Salida", JOptionPane.CLOSED_OPTION);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingreso invalido");
            }

        } while (salir);
    }



    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {
        listaDeEquipos = new ArrayList<>();
        return listaDeEquipos;
    }

    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {
        String opcion = " ";
        opcion = JOptionPane.showInputDialog(null,"Desea cargar los equipos manualmente? SI/NO ",
                "Bienvenida a la carga de equipos",JOptionPane.INFORMATION_MESSAGE);
        if(opcion.toUpperCase().equals("SI")){
            cargarEquipoManualmente(listaDeEquipos);
        } else if(opcion.toUpperCase().equals("NO")) {
            listaDeEquipos.add(new Equipo("Belgica"));
            listaDeEquipos.add(new Equipo("Francia"));
            listaDeEquipos.add(new Equipo("Portutugal"));
            listaDeEquipos.add(new Equipo("Brasil"));
            listaDeEquipos.add(new Equipo("Italia"));
            listaDeEquipos.add(new Equipo("Argelia"));
            listaDeEquipos.add(new Equipo("Alemania"));
            listaDeEquipos.add(new Equipo("Argentina"));
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválido", "ERROR", JOptionPane.CLOSED_OPTION);
        }
    }

    public static Jugador elegirEquipo(ArrayList<Equipo> listaDeEquipos) {
        String listaDeLosEquiposEnMensaje = "Equipos: \n";
        for(int i=0; i<listaDeEquipos.size();i++){
            listaDeLosEquiposEnMensaje+=(i+1)+". "+listaDeEquipos.get(i).getNombre()+"\n";
        }
        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos);
        return jugador;
    }

    public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos) {
        Llave llaveDerecha = new Llave();
        llaveDerecha.armarLlave(listaDeEquipos, 0);
        return llaveDerecha;
    }

    public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {
        Llave llaveIzquierda = new Llave();
        llaveIzquierda.armarLlave(listaDeEquipos, 4);
        return llaveIzquierda;
    }

    public static Ronda crearRondas() {
        // Crea una Ronda
        Ronda ronda = new Ronda();
        return ronda;
    }

    public static void jugarTorneo(Ronda ronda, Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {
        // utiliza las llaves de la izquierda y la derecha para armar los cuartos de final,
        // luego llama al método "sumarPuntos" del jugador y repite el proceso para las semifinales y la final.
        ronda.cuartosDeFInal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        //Semifinal
        ronda.semifinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        //Final
        ronda.finalDelTorneo(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();

    }

    public static void resultadoDelTorneo(Jugador jugador) {
        JOptionPane.showMessageDialog(null,"Has conseguido "+jugador.getPuntaje()
                +" por elegir al equipo: "+jugador.getEquipoSelecionado().getNombre(),"Nombre",JOptionPane.INFORMATION_MESSAGE);

    }

    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos){
        for (int i = 0; i < 8; i++) {
            String nombreDeEquipo = " ";
            nombreDeEquipo = JOptionPane.showInputDialog(null,"Ingrese nombre de equipo"+(i+1)+":",
                    "Bienvenida a la carga de equipos",JOptionPane.INFORMATION_MESSAGE);
            listaDeEquipos.add(new Equipo(nombreDeEquipo));
        }
    }
}
