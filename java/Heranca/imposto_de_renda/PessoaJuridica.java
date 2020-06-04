package Heranca.imposto_de_renda;

import java.util.Objects;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica() {
        // super();
    }

    public PessoaJuridica(String nome, double rendaBruta, String cnpj) {
        super();
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public double calcularImposto() {
        return super.getRendaBruta() + super.getRendaBruta() * 0.1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica PessoaJuridica = (PessoaJuridica) o;
        return Objects.equals(cnpj, PessoaJuridica.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }

    @Override
    public String toString() {
        return "{" + " cnpj='" + getCnpj() + "'" + "}";
    }

}