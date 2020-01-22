package Controladores;

import Modelos.Tarea;
import java.io.*;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Fabricio
 */
public class TareaStream {
    private static RandomAccessFile stream;
    private static int numeroTareas;
    private static final int CANTIDAD_B_TAREAS=500;
    
    public static void crearArchivoTarea(File archivo) throws IOException{
        if (archivo.exists() && !archivo.isFile()) {
            throw new IOException(archivo.getName()+" no es un archivo. ");    
        }
        stream= new RandomAccessFile(archivo,"rw");       
        numeroTareas = (int) Math.ceil((double) stream.length() /
                                       (double) TareaStream.CANTIDAD_B_TAREAS);
    }
    
    
    //======================= METODOS CRUD ==============================================//
    
    //Create
    public static void addTarea(Tarea t) throws IOException{
        setTarea(getNumeroTareas(),t);
        numeroTareas++;
    }
    
    //Read
    public static Tarea getTarea(int i) throws IOException, ParseException{
        if (i>=0 && i<=getNumeroTareas()) {
            stream.seek(i*TareaStream.CANTIDAD_B_TAREAS);
            return new Tarea(stream.readUTF(),stream.readUTF(),stream.readUTF(),stream.readBoolean(),stream.readBoolean());
        }else
            return null;
    }
    //Update
    public static boolean modificarTarea(String tituloModificar) throws IOException, ParseException{
        int pociModificar= buscarTarea(tituloModificar);
        Tarea t=new Tarea();
        
        if (pociModificar == -1) {
            return false;
        }else{
            System.out.println("Digite el nuevo titulo: ");
            t.setTitulo(Leer.datoString());
            System.out.println("\nDigite la nueva descripción: ");
            t.setDescripcion(Leer.datoString());
            t.setFechaCreacion(new Date());
            System.out.println("\nDigite la nueva fecha limite (dia/mes/año): ");
            t.setFechaLimite(Leer.datoString());
            return true;
        }    
    }
    
    //Delete
    public static boolean completarTarea(String tituloTarea) throws IOException, ParseException{
        int pocisionCompletada=buscarTarea(tituloTarea);
        if (pocisionCompletada==-1) {
            return false;
        }else{
            Tarea tareaCompletada = getTarea(pocisionCompletada);
            tareaCompletada.setRealizada(true);
            setTarea(pocisionCompletada,tareaCompletada);
            return true;
        }    
    }
  //===========================================================================// 
    
    public static boolean setTarea(int i,Tarea tarea) throws IOException{
        if (i>=0 && i<= getNumeroTareas()) {
            if (tarea.getTam()>TareaStream.CANTIDAD_B_TAREAS) {
                System.out.println("\nTamaño de registro Excedido");
            }else{
                //ESCRITURA DE DATOS
                stream.seek(i*TareaStream.CANTIDAD_B_TAREAS);
                stream.writeUTF(tarea.getTitulo());
                stream.writeUTF(tarea.getDescripcion());
                stream.writeUTF(tarea.getFechaCreacion());
                stream.writeUTF(tarea.getFechaLimite());
                stream.writeBoolean(tarea.isRealizada());
                stream.writeBoolean(tarea.isEliminada());
                return true;
            }  
            }else{
                System.out.println("Numero de registros fuera de limites");  
        }
                return false;
    }
    
    
    
    public static int buscarTarea(String tituloTarea) throws IOException, ParseException{
        Tarea t;
        if (tituloTarea==null) {
            return -1;
        }
        for (int i = 0; i < getNumeroTareas(); i++) {
            stream.seek(i*getNumeroTareas());
            t= getTarea(i);
            if (t.getTitulo().equals(tituloTarea)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void cerrar() throws IOException{
        stream.close();
    }

    public static int getNumeroTareas() {
        return numeroTareas;
    }
    
    
}
