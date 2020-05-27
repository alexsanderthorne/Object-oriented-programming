import java.util.Objects;

public class CamaroteSup extends VIP {

    private double valorAdSup;

    public CamaroteSup(double valor, double valorAdSup) {
        super();
        this.valorAdSup = valorAdSup;
    }

    // public CamaroteSup(double valorAdSup) {
    // this.valorAdSup = valorAdSup;
    // }

    public double getValorAdSup() {
        return valorAdSup;
    }

    public void setValorAdSup(double valorAdSup) {
        this.valorAdSup = valorAdSup;
    }

    
    public double imprimeValor() {
        return this.valor = this.getValor() + this.getValorAdSup();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CamaroteSup)) {
            return false;
        }
        CamaroteSup camaroteSup = (CamaroteSup) o;
        return valorAdSup == camaroteSup.valorAdSup;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valorAdSup);
    }

    @Override
    public String toString() {
        return "{" + " valorAd='" + getValorAdSup() + "'" + "}";
    }

}