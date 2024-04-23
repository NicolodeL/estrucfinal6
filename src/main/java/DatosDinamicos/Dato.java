package DatosDinamicos;
import DatosDinamicos.pareja;
public class Dato {
    private double datoReal;
    private Pareja pareja;

    public Dato(double datoReal, Pareja pareja) {
        this.datoReal = datoReal;
        this.pareja = pareja;
    }

    public double getDatoReal() {
        return datoReal;
    }

    public Pareja getPareja() {
        return pareja;
    }
}
