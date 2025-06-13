import java.util.ArrayList;
import java.util.List;

public class Fabrica {

    private ArrayList<Maquina> maquinas;
    private int piezas;

    public Fabrica(int piezas) {
        this.maquinas = new ArrayList<>();
        this.piezas = piezas;
    }


    public ArrayList<Maquina> getMaquinas() {
        return new ArrayList<>(this.maquinas);
    }

    public void setMaquinas(Maquina maquinas) {
        this.maquinas.add(maquinas);
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }
}


