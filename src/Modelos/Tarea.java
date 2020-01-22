package Modelos;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Tarea implements Serializable,Comparable{
    private String titulo; //2*letra
    private String descripcion; //2*letra
    private Date fechaCreacion; //32
    private Date fechaLimite; //32
    private boolean realizada; //1
    private boolean eliminada;
    
    
    public Tarea(){
        titulo="Sin título";
        descripcion="Sin descripción";
        fechaCreacion= new Date();
        fechaLimite=null;
        realizada=false;
    }

    public Tarea(String titulo, String descripcion, String fechaLimite, boolean realizada,boolean eliminada) throws ParseException {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = Calendar.getInstance().getTime();;
        this.fechaLimite = new SimpleDateFormat("dd/MM/yyyy").parse(fechaLimite);
        this.realizada = false;
        this.eliminada=eliminada;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(fechaCreacion);
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaLimite() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(fechaLimite);
    }

    public void setFechaLimite(String f) throws ParseException {
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(f); 
        this.fechaLimite = date;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }
    
    
    public int getTam(){
        return titulo.length()*2+descripcion.length()*2+this.getFechaCreacion().length()*2
                +this.getFechaLimite().length()+1+1;
    }

    @Override
    public int compareTo(Object o) {
        Tarea otraTarea= (Tarea) o;
        if (this.fechaLimite.compareTo(otraTarea.fechaLimite)>0) {
            return 1;
        }else if (this.fechaLimite.compareTo(otraTarea.fechaLimite)==0) {
            return 0;
        }else{
            return -1;
        }
    }
   
}
