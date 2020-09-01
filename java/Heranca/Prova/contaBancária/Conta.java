import java.util.ArrayList;
import java.util.Objects;

public class Conta extends Banco {

    private String numero;
    private Banco banco;
    private Cliente c;
    private double saldo;

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    ArrayList<Poupanca> contasPoupancas = new ArrayList<Poupanca>();

    public Conta() {
    }

    public Conta(String numero, String numeroAgencia, String nomeAgencia, Banco banco, Cliente c, double saldo,
            ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
        super(numeroAgencia, nomeAgencia);
        this.numero = numero;
        this.banco = banco;
        this.c = c;
        this.saldo = saldo;
        this.clientes = clientes;
        this.contas = contas;
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

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
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

    public Conta clientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        return this;
    }

    public Conta contas(ArrayList<Conta> contas) {
        this.contas = contas;
        return this;
    }

    public void cadastrarConta(String numero, String numeroAgencia, String nomeAgencia, String nome, String cpf,
            double saldo) {

        clientes.add(new Cliente(nome, cpf));
        contas.add(new Conta(numero, numeroAgencia, nomeAgencia, banco, c, saldo, clientes, contas));
    }

    public void depositarConta(String cpf, double valor) throws Exception {

        if (contas.size() > 0) {

            for (int i = 0; i < contas.size(); i++) {

                if (clientes.get(i).getCpf().equals(cpf)) {
                    // this.saldo = this.getSaldo() + valor;
                    System.out.println("saldo : " + contas.get(i).getSaldo());
                    contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                    System.out.println("Deposito realizado!!!");
                    System.out.println("saldo : " + contas.get(i).getSaldo());
                }
            }

        } else {

            throw new Exception("Conta não cadastrada!.");
        }
    }

    public void consultarConta(String num, String name) throws Exception {

        if (contas.size() > 0) {

            for (int i = 0; i < contas.size(); i++) {

                if (contas.get(i).getNumeroAgencia().equals(num) && contas.get(i).getNomeAgencia().equals(name)) {

                    System.out.println(
                            "NomeCliente : " + clientes.get(i).getNome() + " CpfCliente : " + clientes.get(i).getCpf());

                } else {

                    throw new Exception("Cliente não encontrado!");

                }

            }

        } else {

            throw new Exception("Conta não cadastrada!.");
        }

    }

    public void listarContas() {

        try {

            for (int i = 0; i < contas.size(); i++) {

                System.out.println("Dados da conta : " + contas.get(i).toString());

            }

        } catch (NullPointerException r) {

            System.out.println("Não há contas cadastradas!");

        }

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
                && saldo == conta.saldo && Objects.equals(clientes, conta.clientes)
                && Objects.equals(contas, conta.contas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, banco, c, saldo, clientes, contas);
    }

    @Override
    public String toString() {
        return "{" + " numero='" + getNumero() + "'" + " numeroAgencia='" + getNumeroAgencia() + "'" + ", nomeAgencia='"
                + getNomeAgencia() + "'" + " saldo='" + getSaldo() + ", clientes='" + getClientes() + "'" + "'" + "}";
    }

}