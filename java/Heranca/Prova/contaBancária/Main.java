import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] Args) throws Exception {

        boolean check = true;
        String numero, numeroAgencia, nomeAgencia, nome, cpf;
        double saldo = 0, juros = 0;
        Scanner scan = new Scanner(System.in);

        List<Banco> bancos = new ArrayList<Banco>();
        ArrayList<Conta> contas = new ArrayList<Conta>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Poupanca> contasPoupancas = new ArrayList<Poupanca>();
        ArrayList<Poupanca> clientesP = new ArrayList<Poupanca>();

        Cliente c = new Cliente();
        Conta conta = new Conta();
        Poupanca p = new Poupanca();

        while (check) {

            System.out.println("1. Cadastrar Conta ou Poupança (Pergunte aos clientes o que ele quer cadastrar)");
            System.out.println("2. Realizar depósito (Buscar pelo CPF do cliente)");
            System.out.println("3. Render Juros (Buscar pelo CPF do cliente)");
            System.out.println("4. Consultar número e nome da agência (Mostrar nome e o CPF do cliente)");
            System.out.println("5. Alterar o número e nome da agência (Buscar pelo nome do cliente)");
            System.out.println("6. Listar contas");
            System.out.println("0. Sair");

            int op = 0;
            System.out.println("Digite a opção desejada : ");

            op = scan.nextInt();
            scan.nextLine();

            if (op == 1) {

                int tipoConta = 0;
                System.out.println("Digite '1' para conta normal; '2' para conta poupança; ");
                tipoConta = scan.nextInt();

                if (tipoConta == 1) {

                    System.out.println("Digite o número da conta : ");
                    numero = scan.next();
                    System.out.println("Digite o número da agência : ");
                    numeroAgencia = scan.next();
                    System.out.println("Digite o nome da agência : ");
                    nomeAgencia = scan.next();
                    System.out.println("Digite o nome do titular : ");
                    nome = scan.next();
                    System.out.println("Digite o cpf do titular : ");
                    cpf = scan.next();
                    saldo = 0;

                    conta.cadastrarConta(numero, numeroAgencia, nomeAgencia, nome, cpf, saldo);
                    System.out.println("Conta cadastrada com sucesso!");

                } else if (tipoConta == 2) {

                    System.out.println("Digite o número da agência : ");
                    numeroAgencia = scan.next();
                    System.out.println("Digite o nome da agência : ");
                    nomeAgencia = scan.next();
                    System.out.println("Digite o número da conta : ");
                    numero = scan.next();
                    System.out.println("Digite o nome do titular : ");
                    nome = scan.next();
                    System.out.println("Digite o cpf do titular : ");
                    cpf = scan.next();
                    saldo = 0;
                    juros = 10;

                    p.cadastrarPoupanca(numero, numeroAgencia, nomeAgencia, nome, cpf, saldo, juros);
                    System.out.println("Conta cadastrada com sucesso!");

                }

            } else if (op == 2) {

                int tipoConta = 0;
                System.out.println("Digite 1 para depositar na Conta - 2 Conta poupança");
                tipoConta = scan.nextInt();

                if (tipoConta == 1) {

                    System.out.println("Digite o cpf : ");
                    cpf = scan.next();

                    System.out.println("Digite o valor a ser depositado : ");
                    double valor = scan.nextDouble();

                    conta.depositarConta(cpf, valor);

                } else if (tipoConta == 2) {

                    System.out.println("Digite o cpf : ");
                    cpf = scan.next();

                    System.out.println("Digite o valor a ser depositado : ");
                    double valor = scan.nextDouble();

                    p.depositarPoupanca(cpf, valor);

                } else if (op == 3) {

                    break;
                }

            } else if (op == 4) {

                int tipoConta = 0;
                System.out.println("Digite 1 para Consultar a Conta - 2 Conta poupança");
                tipoConta = scan.nextInt();

                if (tipoConta == 1) {

                    System.out.println("Digite o n° da agencia : ");
                    String num = scan.next();
                    System.out.println("Digite o nome da agencia : ");
                    String name = scan.next();

                    System.out.println("Buscando dados");
                    System.out.println("... ... ...");

                    conta.consultarConta(num, name);

                } else {

                    System.out.println("Digite o n° da agencia : ");
                    String num = scan.next();
                    System.out.println("Digite o nome da agencia : ");
                    String name = scan.next();

                    System.out.println("Buscando dados");
                    System.out.println("... ... ...");

                    p.consultarPoupanca(num, name);
                }

            }

            else if (op == 6) {

                int tipo_conta = 0;

                System.out.println("Digite a conta a qual deseja consultar '1' conta - '2' Poupança");
                tipo_conta = scan.nextInt();

                if (tipo_conta == 1) {

                    System.out.println("Listar contas");
                    System.out.println("*************");
                    conta.listarContas();

                }

                if (tipo_conta == 2) {

                    System.out.println("Listar contas poupança");
                    System.out.println("*************");
                    p.listarPoupanca();
                }

            } else if (op == 0) {

                check = false;
                break;

            } else {

                System.out.println("Opção inválida!");

            }
        }
        scan.close();
    }

}
