import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArchivoFabrica lector = new ArchivoFabrica();
        Fabrica fabrica = lector.cargarDesdeArchivo("src/config.txt");

        if (fabrica != null) {
            Greedy algoritmoGreedy = new Greedy();
            BackTraking algoritmoBacktracking = new BackTraking();
            Resultados resultadosGreedy = algoritmoGreedy.greedy(fabrica);
            Resultados resultadosBacktracking = algoritmoBacktracking.backTranking(fabrica);

            System.out.println("Mejor secuencia Greedy:");
            if (!resultadosGreedy.getSecuencias().isEmpty()) {
                List<Maquina> mejorSecuenciaGreedy = resultadosGreedy.getSecuencias().get(0);
                for (Maquina m : mejorSecuenciaGreedy) {
                    System.out.println(m.getNombre() + " (" + m.getNroPiezas() + " piezas)");
                }
            } else {
                System.out.println("No se encontró ninguna secuencia válida.");
            }

            System.out.println("Piezas producidas: " + resultadosGreedy.getPiezasProducidas());
            System.out.println("Marchas: " + resultadosGreedy.getMarchas());
            System.out.println("Estados generados: " + resultadosGreedy.getEstados());

            System.out.println();

            System.out.println("Mejor secuencia Backtracking:");
            if (!resultadosBacktracking.getSecuencias().isEmpty()) {
                List<Maquina> mejorSecuenciaBacktracking = resultadosBacktracking.getSecuencias().get(0);
                for (Maquina m : mejorSecuenciaBacktracking) {
                    System.out.println(m.getNombre() + " (" + m.getNroPiezas() + " piezas)");
                }
            } else {
                System.out.println("No se encontró ninguna secuencia válida.");
            }

            System.out.println("Piezas producidas: " + resultadosBacktracking.getPiezasProducidas());
            System.out.println("Marchas: " + resultadosBacktracking.getMarchas());
            System.out.println("Estados generados: " + resultadosBacktracking.getEstados());

        }
    }

}
