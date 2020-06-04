package Heranca.imposto_de_renda;

import java.util.Objects;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, double rendaBruta, String cpf) {
        super();
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public double calcularImposto() {

        double imposto = 0;

        if (super.getRendaBruta() <= 1400) {
            imposto = this.getRendaBruta();
        } else if (super.getRendaBruta() > 1400 && super.getRendaBruta() <= 2100) {
            imposto = this.getRendaBruta() + (this.getRendaBruta() * 0.1) - 100;
        } else if (super.getRendaBruta() > 2100 && super.getRendaBruta() <= 2800) {
            imposto = this.getRendaBruta() + (this.getRendaBruta() * 0.15) - 270;
        } else if (super.getRendaBruta() > 2800 && super.getRendaBruta() <= 3600) {
            imposto = this.getRendaBruta() + (this.getRendaBruta() * 0.25) - 500;
        } else {
            imposto = this.getRendaBruta() + (this.getRendaBruta() * 0.3) - 700;

        }
        return imposto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica pessoaFisica = (PessoaFisica) o;
        return Objects.equals(cpf, pessoaFisica.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "{" + " cpf='" + getCpf() + "'" + "}";
    }

}