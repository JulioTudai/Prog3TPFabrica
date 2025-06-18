import java.util.ArrayList;
import java.util.Collections;

public class Greedy {

    /*
     * Algoritmo Greedy:
     * la estrategia consiste en seleccionar en cada paso la máquina que produce la mayor cantidad de piezas
     * posible sin superar el total de piezas que necesitamos.
     * los candidatos son todas las maquinas disponibles.
     * se ordenan las maquinas de mayor a menor segun la cantidad de piezas que producen.
     * en cada iteración:
     * se elige la máquina de mayor producción disponible.
     * si al sumar sus piezas no se supera el total de piezas requeridas, se agrega a la solución.
     * para optimizar la solucion, si esa maquina todavia sirve para una posible solucion la dejamos en el
     * conjunto de maquinas para usar
     * si supera el total, se descarta (se elimina de la lista para una posible solucion) y se evalua la siguiente.
     * el proceso continúa hasta que se logre exactamente la cantidad de piezas requerida o se agoten las maquinas.
     *
     * la metrica de costo utilizada es la cantidad de candidatos evaluados (cantidad de veces que se elige
     * una maquina durante el proceso).
     */


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
