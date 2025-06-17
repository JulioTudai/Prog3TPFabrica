import java.util.ArrayList;
import java.util.Collections;

public class Greedy {


    public Resultados greedy(Fabrica fabrica) {
        Resultados resultados = new Resultados(0, 0, 0);
        ArrayList<Maquina> solucion = new ArrayList<>();

        obtenerResultados(fabrica.getMaquinas(), fabrica.getPiezas(), solucion, resultados);
        resultados.addSecuencia(solucion);
        return resultados;

    }

    private void obtenerResultados(ArrayList<Maquina> maquinas, int piezas, ArrayList<Maquina> solucion, Resultados resultados) {
        Collections.sort(maquinas);
        int suma = 0;
        int marchas = 0;
        int nroPieza;
        while (!maquinas.isEmpty() && !esSolucion(solucion, piezas)) {
            resultados.setEstados(resultados.getEstados() + 1);
            Maquina mayorProduccion = maquinas.get(maquinas.size()-1);
            nroPieza =  mayorProduccion.getNroPiezas();

            if ( suma + nroPieza <= piezas ){
                marchas ++;
                resultados.setMarchas(marchas);
                suma += nroPieza;
                solucion.add(mayorProduccion);
            }

            if (suma + nroPieza > piezas){
                maquinas.remove(mayorProduccion);
            }

        }
        resultados.setPiezasProducidas(suma);

    }

    private boolean esSolucion(ArrayList<Maquina> actuales, int piezas) {
        int suma = 0;
        for (Maquina m : actuales) {
            suma += m.getNroPiezas();
        }
        return suma == piezas;
    }
}
