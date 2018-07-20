
import java.util.Queue;
import java.util.LinkedList;
public class CentroAlquiler{

    private int capacidad;
    private int identificador;
    private Queue<Coche> centro;

    public CentroAlquiler(int identificador,int capacidad){
        this.identificador=identificador;
        this.capacidad=capacidad;
        centro= new LinkedList<Coche>();

        for(int i =0;i<this.capacidad;i++){
            centro.add(new Coche((this.identificador*10)+i));
        }
    }

    public int getID(){
        return this.identificador;
    }

    /*
        FALTA MIRAR EL TIPO DEL CLIENTE PARA ALQUILAR EL NUMERO DE COCHES DEL ENUNCIADO
     */

    public synchronized Coche alquila(String idUsuario){
        System.out.println("El usuario "+idUsuario+" quiere alquilar un coche en la estacion "+this.identificador);

        Coche coche= centro.poll();
        if(coche==null){
            System.out.println("No hay coches disponibles y el usuario "+idUsuario+" no puede alquilar");
            try{
                wait(20000);
            }catch(Exception e){}
        }
        if(coche==null){
            System.out.println("Abandona");
            return null;
        }
        System.out.println("El usuario "+idUsuario+" alquila un coche en la estacion "+this.identificador);
        notifyAll();
        return coche;
    }

    public synchronized void devuelve(String idUsuario, Coche coche){
        System.out.println("El usuario "+idUsuario+" quiere devolver un coche en la estacion "+this.identificador);

        while(centro.size()==capacidad){
            System.out.println("No se puede devolver. Tenemos el centro lleno.");
            try{
                wait();
            }catch(Exception e){}
        }
        System.out.println("El usuario "+idUsuario+" devuelve el coche");
        centro.add(coche);
        notifyAll();
    }



}