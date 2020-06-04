import java.util.Objects;

public abstract class Ingresso {

    protected double valor;

    public Ingresso() {
    }

    public Ingresso(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Ingresso valor(double valor) {
        this.valor = valor;
        return this;
    }

    public abstract double imprimeValor();

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ingresso)) {
            return false;
        }
        Ingresso ingresso = (Ingresso) o;
        return valor == ingresso.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valor);
    }

    @Override
    public String toString() {
        return "{" + " valor='" + getValor() + "'" + "}";
    }

}