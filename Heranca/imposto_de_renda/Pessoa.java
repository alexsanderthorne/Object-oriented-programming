package Heranca.imposto_de_renda;

import java.util.Objects;

public abstract class Pessoa {

    private String nome;
    private double rendaBruta;

    public Pessoa() {
    }

    public Pessoa(String nome, double rendaBruta) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRendaBruta() {
        return this.rendaBruta;
    }

    public void setRendaBruta(double rendaBruta) {
        this.rendaBruta = rendaBruta;
    }

    public Pessoa nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pessoa rendaBruta(double rendaBruta) {
        this.rendaBruta = rendaBruta;
        return this;
    }

    public abstract double calcularImposto();

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && rendaBruta == pessoa.rendaBruta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, rendaBruta);
    }

    @Override
    public String toString() {
        return "{" + " nome='" + getNome() + "'" + ", rendaBruta='" + getRendaBruta() + "'" + "}";
    }

}