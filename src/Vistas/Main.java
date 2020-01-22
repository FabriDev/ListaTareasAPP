package Vistas;

import Controladores.Metodos;
import Controladores.Leer;
import Controladores.TareaStream;
import Modelos.Tarea;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.TreeSet;

/**
 *
 * @author Fabricio
 */
public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        int operacion;
        TreeSet listaTareas = new TreeSet<>();

        for (int i = 0; i < TareaStream.getNumeroTareas(); i++) {
            listaTareas.add(TareaStream.getTarea(i));
        }

        do {
            UIConsola.imprimirEncabezado("LISTA DE TAREAS");
            System.out.println("1. Crear nueva tarea\n"
                    + "2. Buscar tarea \n"
                    + "3. Modificar tarea\n"
                    + "4. Marcar tarea como realizada\n"
                    + "4. Eliminar tarea\n"
                    + "5. Mostrar todas las tareas\n"
                    + "6. Eliminar todas las tareas realizadas\n"
                    + "7. Salir");

            System.out.print("\n\n----->");
            operacion = Leer.datoInt();
            UIConsola.imprimirLinea();

            switch (operacion) {
                //Crear Nueva Tarea
                case 1:
                    try {
                        UIConsola.imprimirEncabezado("Nueva tarea");
                        Tarea t = Metodos.crearTarea();
                        TareaStream.crearArchivoTarea(new File("tareas.dat"));
                        TareaStream.addTarea(t);
                        TareaStream.cerrar();
                    } catch (IOException e) {
                        System.out.println("Error al añadir la nueva tarea");
                    }
                    TareaStream.cerrar();
                    break;
                //Buscar Tarea  
                case 2:
                    String tituloAbuscar;
                    System.out.println("Digita el titulo de la tarea a buscar: ");
                    tituloAbuscar = Leer.datoString();
                    if (tituloAbuscar.isEmpty()) {
                        System.out.println("No se ingreso el titulo de la tarea!");
                    } else {
                        try {

                            TareaStream.crearArchivoTarea(new File("tareas.dat"));
                            int i = TareaStream.buscarTarea(tituloAbuscar);

                            if (i == -1) {
                                System.out.println("No se encontraron tareas con ese nombre");
                            } else {
                                System.out.println("La primera coincidencia indica");
                                UIConsola.imprimirTarea(TareaStream.getTarea(i));
                            }
                        } catch (IOException e) {
                            System.out.println("Error al buscar la tarea");
                        } finally {
                            TareaStream.cerrar();
                        }
                    }

            }

        } while (operacion != 7);

        // Tarea t = new Tarea("Titulo de prueba", "Descripcion de prueba", "05/06/2021", false);
        //UIConsola.imprimirTarea(t);
    }
}
