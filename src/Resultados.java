import java.util.ArrayList;
import java.util.List;

public class Resultados {

    private List<List<Maquina>> secuencias;
    private int piezasProducidas;
    private int marchas;
    private int estados;

    public Resultados(int piezasProducidas, int marchas, int estados) {
        this.secuencias = new ArrayList<>();
        this.piezasProducidas = piezasProducidas;
        this.marchas = marchas;
        this.estados = estados;
    }
    public void addSecuencia(List<Maquina> secuencia) {
        this.secuencias.add(new ArrayList<>(secuencia)); // defensiva
    }

    public List<List<Maquina>> getSecuencias() {
        List<List<Maquina>> copia = new ArrayList<>();
        for (List<Maquina> secuencia : this.secuencias) {
            copia.add(new ArrayList<>(secuencia));
        }
        return copia;
    }

    public void setSecuencias(List<List<Maquina>> secuencias) {
        this.secuencias = secuencias;
    }

    public int getPiezasProducidas() {
        return piezasProducidas;
    }

    public void setPiezasProducidas(int piezasProducidas) {
        this.piezasProducidas = piezasProducidas;
    }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }

    public int getEstados() {
        return estados;
    }

    public void setEstados(int estados) {
        this.estados = estados;
    }
}
