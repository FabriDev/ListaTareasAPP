package Vistas;

import Modelos.Tarea;
import java.text.SimpleDateFormat;

public class UIConsola {
    public static void imprimirLinea(){
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public static void imprimirEncabezado(String titulo){
        imprimirLinea();
        System.out.println("\t"+titulo);
        imprimirLinea();
    }
    
    public static void imprimirTarea(Tarea t){
        System.out.println("\n");
        imprimirLinea();
        System.out.println("-> "+t.getTitulo());
        System.out.println(t.getDescripcion());
        System.out.println("\nRealizada: " + (t.isRealizada()?"SI":"NO") );
        System.out.println("Fecha Limite: "+ t.getFechaLimite());
        
        System.out.println("Ultima modificacion: "+t.getFechaCreacion());
        imprimirLinea();
        System.out.println("\n\n");
    }
}
