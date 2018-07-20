public class Main{
    public static void main(String[] args) {
        java.util.Random rnd=new java.util.Random();

        CentroAlquiler centro1 = new CentroAlquiler(1,2);
        CentroAlquiler centro2 = new CentroAlquiler(2,3);

        Cliente [] clientesEmpresa = new Cliente[5];
        Cliente [] clientesPersonas = new Cliente[5];

        for (int i = 0; i < clientesEmpresa.length; i++) {
            clientesEmpresa[i] = new Cliente(i, 'e', centro1, centro2);
            clientesPersonas[i] = new Cliente(i, 'p', centro1, centro2);
        }

        for(int i=0;i<clientesEmpresa.length;i++){
            clientesEmpresa[i].start();
            clientesPersonas[i].start();
        }

        for(int i=0;i<clientesEmpresa.length;i++){
            try{
                clientesEmpresa[i].join();
                clientesPersonas[i].join();
            }catch(Exception e){ }
        }
    }
}