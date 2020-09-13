import java.util.Objects;

public class Poupanca extends Conta {

    private double juros;

    public Poupanca(String numero, Banco banco, Cliente c, double saldo, double juros) {
        super(numero, banco, c, saldo);
        this.juros = juros;
    }

    public Poupanca() {
    }


    public double renderJuros(){
        return this.getSaldo() + (this.getSaldo() * this.getJuros());
    }

    public double getJuros() {
        return this.juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public Poupanca juros(double juros) {
        this.juros = juros;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Poupanca)) {
            return false;
        }
        Poupanca poupanca = (Poupanca) o;
        return juros == poupanca.juros;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(juros);
    }

    @Override
    public String toString() {
        return "{" + " Poupança: Numero='" + getNumero() + "'" + ", Banco='" + getBanco() + "'" + ", Cliente='" + getC() + "'"
        + ", saldo='" + getSaldo() + "'" + " juros='" + getJuros() + "'" + "}";
    }

}