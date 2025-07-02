import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArchivoFabrica lector = new ArchivoFabrica();
        Fabrica fabrica = lector.cargarDesdeArchivo("C:\\Users\\victo\\OneDrive\\Escritorio\\Prog3TPFabrica\\src/config.txt");

        if (fabrica != null) {
            Greedy algoritmoGreedy = new Greedy();
            BackTraking algoritmoBacktracking = new BackTraking();
            Resultados resultadosGreedy = algoritmoGreedy.greedy(fabrica);
            Resultados resultadosBacktracking = algoritmoBacktracking.backTranking(fabrica);

            System.out.println("Mejor secuencia Greedy:");
            if (resultadosGreedy.getPiezasProducidas() == fabrica.getPiezas()){
                System.out.println("Piezas producidas: " + resultadosGreedy.getPiezasProducidas());
                System.out.println("Marchas: " + resultadosGreedy.getMarchas());
                System.out.println("Estados generados: " + resultadosGreedy.getEstados());
                System.out.println("Secuencia:");
                System.out.println(resultadosGreedy.getSecuencias());

            }
            else {
                System.out.println("no hay solucion greedy");
            }

            System.out.println("Mejor secuencia Backtracking:");
            if (resultadosBacktracking.getPiezasProducidas() == fabrica.getPiezas()){
                System.out.println("Piezas producidas: " + resultadosBacktracking.getPiezasProducidas());
                System.out.println("Marchas: " + resultadosBacktracking.getMarchas());
                System.out.println("Estados generados: " + resultadosBacktracking.getEstados());
                System.out.println("Secuencia:");
                System.out.println(resultadosBacktracking.getSecuencias());

            }else {
                System.out.println("no hay solucion backtracking");
            }




        }



    }

}
