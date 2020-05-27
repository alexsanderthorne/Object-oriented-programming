public class Normal extends Ingresso {

    public Normal() {

    }

    public Normal(double valor) {
        super();
    }

    public double valorIngressoNormal() {
        return this.valor = this.getValor();
    }

    @Override
    public double imprimeValor() {

        return this.valor = this.valorIngressoNormal();

    }

}