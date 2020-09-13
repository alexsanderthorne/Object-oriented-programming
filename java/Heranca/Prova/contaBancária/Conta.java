import java.util.Objects;

public class Conta {

    private String numero;
    private Banco banco;
    private Cliente c;
    private double saldo;

    public Conta() {
    }

    public Conta(String numero, Banco banco, Cliente c, double saldo) {
        this.numero = numero;
        this.banco = banco;
        this.c = c;
        this.saldo = saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Banco getBanco() {
        return this.banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Cliente getC() {
        return this.c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta numero(String numero) {
        this.numero = numero;
        return this;
    }

    public Conta banco(Banco banco) {
        this.banco = banco;
        return this;
    }

    public Conta c(Cliente c) {
        this.c = c;
        return this;
    }

    public Conta saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Conta)) {
            return false;
        }
        Conta conta = (Conta) o;
        return Objects.equals(numero, conta.numero) && Objects.equals(banco, conta.banco) && Objects.equals(c, conta.c)
                && saldo == conta.saldo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, banco, c, saldo);
    }

    @Override
    public String toString() {
        return "{" + " Conta: Numero='" + getNumero() + "'" + ", Banco='" + getBanco() + "'" + ", Cliente='" + getC() + "'"
                + ", saldo='" + getSaldo() + "'" + "}";
    }

}