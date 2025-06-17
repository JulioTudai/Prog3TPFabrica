import java.util.List;

public class Main {
    public static void main(String[] args) {
            Fabrica fabrica = new Fabrica(12);

            Maquina m1 = new Maquina("M1", 7);
            Maquina m2 = new Maquina("M2", 3);
            Maquina m3 = new Maquina("M3", 4);
            Maquina m4 = new Maquina("M4", 1);

            fabrica.setMaquinas(m1);
            fabrica.setMaquinas(m2);
            fabrica.setMaquinas(m3);
            fabrica.setMaquinas(m4);
            /*

            BackTraking back = new BackTraking();
            Resultados r = back.backTranking(fabrica);

            System.out.println("Mejor secuencia:");

            if (!r.getSecuencias().isEmpty()) {
                List<Maquina> mejorSecuencia = r.getSecuencias().get(0);
                for (Maquina m : mejorSecuencia) {
                    System.out.println(m.getNombre() + " (" + m.getNroPiezas() + " piezas)");
                }
            } else {
                System.out.println("No se encontró ninguna secuencia válida.");
            }

            System.out.println("Piezas producidas: " + r.getPiezasProducidas());
            System.out.println("Marchas: " + r.getMarchas());
            System.out.println("Estados generados: " + r.getEstados());

             */

        Greedy algoritmo = new Greedy();
        Resultados resultados = algoritmo.greedy(fabrica);
        System.out.println("Mejor secuencia:");

        if (!resultados.getSecuencias().isEmpty()) {
            List<Maquina> mejorSecuencia = resultados.getSecuencias().get(0);
            for (Maquina m : mejorSecuencia) {
                System.out.println(m.getNombre() + " (" + m.getNroPiezas() + " piezas)");
            }
        } else {
            System.out.println("No se encontró ninguna secuencia válida.");
        }

        System.out.println("Piezas producidas: " + resultados.getPiezasProducidas());
        System.out.println("Marchas: " + resultados.getMarchas());
        System.out.println("Estados generados: " + resultados.getEstados());



    }
    }
