package Controladores;

import java.io.*;

public class Leer 
{
    public static String dato()
    {
        String sdato ="";
        try
        {
            //DEFINIR UN FLUJO DE CARACTERES DE ENTRADA; flujoE
            InputStreamReader read = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(read);
            //LEER. LA ENTRADA FINALIZA AL PULSAR LA TECLA ENTRAR
            sdato = flujoE.readLine();
        }
        catch(IOException e)
        {
            System.err.println("Error: "+e.getMessage());
        }
        return sdato; //DEVUELVE EL DATO TECLEADO
    }
    public static String datoString()
    {
            return dato();
    }
    public static short datoShort()
    {
        try
        {
            return Short.parseShort(dato());
        }
        catch(NumberFormatException e)
        {
            return Short.MIN_VALUE; //VALOR MAS PEQUENO
        }
    }
    public static int datoInt()
    {
        try
        {
            return Integer.parseInt(dato());
        }
        catch(NumberFormatException e)
        {
            return Integer.MIN_VALUE; //VALOR MAS PEQUENO
        }
    }    
    public static long datoLong()
    {
        try
        {
            return Long.parseLong(dato());
        }
        catch(NumberFormatException e)
        {
            return Long.MIN_VALUE; //VALOR MAS PEQUENO
        }
    }    
    public static float datoFloat()
    {
        try
        {
            Float f = new Float(dato());
            return f.floatValue();
        }
        catch(NumberFormatException e)
        {
            return Float.NaN; //NO ES UN NUMERO: VALOR FLOAT
        }
    }
    public static double datoDouble()
    {
        try
        {
            Double d = new Double(dato());
            return d.doubleValue();
        }
        catch(NumberFormatException e)
        {
            return Double.NaN; //NO ES UN NUMERO: VALOR FLOAT
        }
    }        
}//fin class
