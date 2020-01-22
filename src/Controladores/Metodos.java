
package Controladores;

import Modelos.Tarea;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;


public class Metodos {
    
    public static Tarea crearTarea() throws ParseException{
        Tarea t=new Tarea();
        System.out.println("Digita el titulo de la nueva tarea:");
        t.setTitulo(Leer.datoString());
        System.out.println("Digita una descripcion de la tarea: ");
        t.setDescripcion(Leer.datoString());
        System.out.println("Digite la fecha límite de la tarea(dia/mes/año): ");
        t.setFechaLimite(Leer.datoString());
        return t;
    }
    
    
}
