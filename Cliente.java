public class Cliente extends Thread{

    private int identificador;
    private char tipo;
    private CentroAlquiler centro1;
    private CentroAlquiler centro2;


    public Cliente(int identificador,char tipo, CentroAlquiler centro1,CentroAlquiler centro2){
        this.identificador=identificador;
        this.tipo=tipo;
        this.centro1=centro1;
        this.centro2=centro2;
    }


    /*
        FALTA MIRAR EL TIPO DEL CLIENTE PARA ALQUILAR EL NUMERO DE COCHES DEL ENUNCIADO
     */
    @Override
    public void run(){
        java.util.Random rnd=new java.util.Random();
        Coche alquiler= centro1.alquila(""+identificador+tipo);
        if(alquiler!=null){
            try{
                Thread.sleep(3000+rnd.nextInt(6000));
            }catch(Exception e){}

            centro2.devuelve(""+identificador+tipo,alquiler);

        }



    }

    private int getID(){
        return this.identificador;
    }

}