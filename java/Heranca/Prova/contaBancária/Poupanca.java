import java.util.ArrayList;
import java.util.Objects;

public class Poupanca extends Conta {

    private double juros;
    private Banco banco;
    private Cliente c;

    private ArrayList<Cliente> clientesP = new ArrayList<Cliente>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Conta> contas = new ArrayList<Conta>();
    ArrayList<Poupanca> contasPoupancas = new ArrayList<Poupanca>();

    public Poupanca() {
    }

    public Poupanca(String numero, String numeroAgencia, String nomeAgencia, Banco banco, Cliente c, double saldo,
            double juros, ArrayList<Cliente> clientes, ArrayList<Cliente> clientesP, ArrayList<Conta> contas,
            ArrayList<Poupanca> contasPoupancas) {
        super(numero, numeroAgencia, nomeAgencia, banco, c, saldo, clientes, contas);
        this.juros = juros;
        this.banco = banco;
        this.clientesP = clientesP;
        this.c = c;
        this.contasPoupancas = contasPoupancas;
        this.contas = contas;

    }

    public void cadastrarPoupanca(String numero, String numeroAgencia, String nomeAgencia, String nome, String cpf,
            double saldo, double juros) {

        clientesP.add(new Cliente(nome, cpf));
        contasPoupancas.add(new Poupanca(numero, numeroAgencia, nomeAgencia, banco, c, saldo, juros, clientes,
                clientesP, contas, contasPoupancas));

    }

    public void depositarPoupanca(String cpf, double valor) throws Exception {

        if (contasPoupancas.size() > 0) {

            for (int i = 0; i < contasPoupancas.size(); i++) {

                if (clientesP.get(i).getCpf().equals(cpf)) {

                    System.out.println("saldo : " + contasPoupancas.get(i).getSaldo());
                    contasPoupancas.get(i).setSaldo(contasPoupancas.get(i).getSaldo() + valor);
                    System.out.println("Deposito realizado!!!");
                    System.out.println("saldo : " + contasPoupancas.get(i).getSaldo());

                    break;

                }
            }

        } else {

            throw new Exception("Não há conta cadastrada.");
        }

    }

    public void renderJuros(String cpf, double juros) {

        if (contasPoupancas.size() > 0) {

            for (int i = 0; i < contasPoupancas.size(); i++) {

                if (clientesP.get(i).getCpf().equals(cpf)) {

                    System.out.println("saldo : " + contasPoupancas.get(i).getSaldo());
                    contasPoupancas.get(i).setSaldo(contasPoupancas.get(i).getSaldo() + juros);
                    System.out.println(" Dia de rendimento!!!");
                    System.out.println("saldo atualizado : " + contasPoupancas.get(i).getSaldo());

                }

                if (!(clientesP.get(i).getCpf().equals(cpf))) {

                    System.out.println("Cliente não encontrado!");

                }
            }
        }
    }

    public void alterarDadosConta(String nome, String numeroAgencia, String nomeAgencia) {

        if (contasPoupancas.size() > 0) {

            for (int i = 0; i < contasPoupancas.size(); i++) {
                
                if ((clientesP).get(i).getNome().equals(nome)) {
                    System.out.println("Teste");

                    contasPoupancas.get(i).setNumeroAgencia(numeroAgencia);
                    contasPoupancas.get(i).setNomeAgencia(nomeAgencia);
                    System.out.println(contasPoupancas.get(i).getNumeroAgencia());
                    System.out.println(contasPoupancas.get(i).getNomeAgencia());
                    System.out.println("DADOS ATUALIZADOs.");

                }
            }

        } else {

            System.out.println("Não possui contas cadastradas.");
        }

    }

    public void consultarPoupanca(String num, String name) throws Exception {

        if (contasPoupancas.size() > 0) {

            for (int i = 0; i < contasPoupancas.size(); i++) {

                if (contasPoupancas.get(i).getNumeroAgencia().equals(num)
                        && contasPoupancas.get(i).getNomeAgencia().equals(name)) {

                    System.out.println("NomeCliente : " + clientesP.get(i).getNome() + " CpfCliente : "
                            + clientesP.get(i).getCpf());

                }

            }

        } else {

            throw new Exception("Conta não cadastrada!.");
        }

    }

    public void listarPoupanca() {

        if (contasPoupancas.size() > 0) {

            for (int i = 0; i < contasPoupancas.size(); i++) {

                System.out.println("Dados da conta : " + contasPoupancas.get(i).toString());

            }

        } else {

            System.out.println("Não há contas cadastradas!");

        }
    }

    public double getJuros() {
        return this.juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public Banco getBanco() {
        return this.banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public ArrayList<Cliente> getClientesP() {
        return this.clientesP;
    }

    public void setClientesP(ArrayList<Cliente> clientesP) {
        this.clientesP = clientesP;
    }

    public Cliente getC() {
        return this.c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public ArrayList<Poupanca> getContasPoupancas() {
        return this.contasPoupancas;
    }

    public void setContasPoupancas(ArrayList<Poupanca> contasPoupancas) {
        this.contasPoupancas = contasPoupancas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Poupanca)) {
            return false;
        }
        Poupanca poupanca = (Poupanca) o;
        return juros == poupanca.juros && Objects.equals(banco, poupanca.banco) && Objects.equals(c, poupanca.c)
                && Objects.equals(clientesP, poupanca.clientesP) && Objects.equals(clientes, poupanca.clientes)
                && Objects.equals(contas, poupanca.contas) && Objects.equals(contasPoupancas, poupanca.contasPoupancas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(juros, banco, c, clientesP, clientes, contas, contasPoupancas);
    }

    @Override
    public String toString() {
        return "{" + " numero='" + getNumero() + "'" + " numeroAgencia='" + getNumeroAgencia() + "'" + ", nomeAgencia='"
                + getNomeAgencia() + " saldo='" + getSaldo() + "'" + ", clientes='" + getClientes() + "'" + " juros='"
                + getJuros() + "'" + "'" + "}";
    }

}