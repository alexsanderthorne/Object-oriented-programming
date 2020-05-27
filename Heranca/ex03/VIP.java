import java.util.Objects;

public abstract class VIP extends Ingresso {

    private double valorAd;

    public VIP() {
        super();
    }

    public VIP(double valorAd) {
        this.valorAd = valorAd;
    }

    public double getValorAd() {
        return this.valorAd;
    }

    public void setValorAd(double valorAd) {
        this.valorAd = valorAd;
    }

    public VIP valorAd(double valorAd) {
        this.valorAd = valorAd;
        return this;
    }

    @Override
    public abstract double imprimeValor();

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VIP)) {
            return false;
        }
        VIP vIP = (VIP) o;
        return valorAd == vIP.valorAd;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valorAd);
    }

    @Override
    public String toString() {
        return "{" + " valorAd='" + getValorAd() + "'" + "}";
    }

}