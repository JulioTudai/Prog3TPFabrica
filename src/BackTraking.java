import java.util.ArrayList;
import java.util.List;

public class BackTraking {

    /*
     * Algoritmo Backtracking:
     * arbol de exploracion: cada nodo representa un estado parcial una secuencia actual de maquinas ya utilizadas.
     * el estado inicial es una secuencia vacia.
     * en cada paso (cada nivel del arbol) se elige una maquina para agregar a la secuencia y se avanza recursivamente.
     * los estados solucion son aquellos en los que la suma total de piezas producidas por la secuencia actual
     * es igual a la cantidad de piezas necesarias.
     * las hojas del árbol representan todas las combinaciones posibles de uso de máquinas pero muchas son podadas.
     *
     * se usan podas para reducir iteraciones:
     * si al sumar la cantidad de piezas de la secuencia actual mas la cantidad de piezas de la proxima máquina
     * se supera el total requerido, se descarta esa rama evitando combinaciones innecesarias.
     * si ya existe una solución mejor (con menor cantidad de puestas en marcha), y la cantidad de máquinas
     * de la secuencia actual ya es mayor o igual a la mejor solución encontrada, también se poda.
     * el costo utilizado es la cantidad de estados generados (cantidad de veces que se entra a la funcion obtenerResultados()).
     */

    public Resultados backTranking(Fabrica fabrica){

        Resultados resultados = new Resultados(0, 0, 0);
        ArrayList<Maquina> maquinasActuales = new ArrayList<>();

        obtenerResultados(fabrica.getMaquinas(), fabrica.getPiezas(), maquinasActuales, resultados);
        return resultados;

    }

    private void obtenerResultados(ArrayList<Maquina> maquinas, int piezas, ArrayList<Maquina> maquinasActuales, Resultados resultados) {

        resultados.setEstados(resultados.getEstados() + 1);

        if (esSolucion(maquinasActuales, piezas)) {

            mejorSolucion(maquinasActuales, resultados);

        } else {

            for (int i = 0; i < maquinas.size(); i++) {
                Maquina m = maquinas.get(i);

                if (!poda(maquinasActuales, m.getNroPiezas(), piezas) ) {

                    boolean noHaySoluciones = resultados.getSecuencias().isEmpty();
                    boolean esMasCortaQueLaMejor = !noHaySoluciones && maquinasActuales.size() + 1 < resultados.getSecuencias().get(0).size();

                    if (noHaySoluciones || esMasCortaQueLaMejor) {
                        maquinasActuales.add(m);
                        obtenerResultados(maquinas, piezas, maquinasActuales, resultados);
                        maquinasActuales.remove(maquinasActuales.size() - 1);
                    }
                }
            }
        }
    }

    private boolean esSolucion(ArrayList<Maquina> actuales,int piezas){


        int suma=0;
        for (Maquina m : actuales){

            suma += m.getNroPiezas();

        }
        return suma == piezas;

    }

    private void mejorSolucion(ArrayList<Maquina> actuales, Resultados resultados){

        if (resultados.getSecuencias().isEmpty() ||
                actuales.size() < resultados.getSecuencias().get(0).size()) {

            List<Maquina> nuevaSolucion = new ArrayList<>(actuales);
            resultados.setSecuencias(new ArrayList<>());
            resultados.addSecuencia(nuevaSolucion);

            resultados.setMarchas(nuevaSolucion.size());

            int totalPiezas = 0;
            for (Maquina m : nuevaSolucion) {
                totalPiezas += m.getNroPiezas();
            }
            resultados.setPiezasProducidas(totalPiezas);
        }

    }

    public boolean poda(ArrayList<Maquina> actuales,int piezasSiguientes,int pTotales){
        int suma = 0;

        for (Maquina m : actuales){
            suma += m.getNroPiezas();
        }
        return suma + piezasSiguientes > pTotales;

    }



}
