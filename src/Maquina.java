import java.lang.Comparable;

public class Maquina implements Comparable<Maquina> {


    private String nombre;
    private int nroPiezas;



    public Maquina (String nombre, int nroPiezas){

        this.nombre = nombre;
        this.nroPiezas = nroPiezas;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroPiezas() {
        return nroPiezas;
    }

    public void setNroPiezas(int nroPiezas) {
        this.nroPiezas = nroPiezas;
    }

    @Override
    public int compareTo(Maquina o) {
        return Integer.compare(this.nroPiezas, o.nroPiezas);
    }
}
