package Heranca.ex03;

import java.util.Objects;

public class CamaroteInf extends VIP {

    private double[][] localizacao;

    public CamaroteInf(double valorAd, double[][] localizacao) {
        super();
        this.localizacao = localizacao;
    }

    // public CamaroteInf(double[][] localizacao) {
    // this.localizacao = localizacao;
    // }

    public double[][] getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(double[][] localizacao) {
        this.localizacao = localizacao;
    }

    public CamaroteInf localizacao(double[][] localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public double[][] acessarLocalizacao() {
        return this.getLocalizacao();

    }

    // @Override
    public double imprimeValor() {
        return this.valor = this.getValor() + 66;

    }

    public double[][] imprimirLocalizacao() {
        return this.getLocalizacao();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CamaroteInf)) {
            return false;
        }
        CamaroteInf camaroteInf = (CamaroteInf) o;
        return Objects.equals(localizacao, camaroteInf.localizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(localizacao);
    }

    @Override
    public String toString() {
        return "{" + " localizacao='" + getLocalizacao() + "'" + "}";
    }

}