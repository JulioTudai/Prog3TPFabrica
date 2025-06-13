import java.util.ArrayList;
import java.util.List;

public class BackTraking {

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

                    if (!resultados.getSecuencias().isEmpty() &&
                            maquinasActuales.size() + 1 < resultados.getSecuencias().get(0).size()) {
                        maquinasActuales.add(m);
                        obtenerResultados(maquinas, piezas, maquinasActuales, resultados);
                        maquinasActuales.remove(maquinasActuales.size() - 1);
                    }
                    else if(resultados.getSecuencias().isEmpty()){
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
