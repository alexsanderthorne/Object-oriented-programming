import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args) {

        Scanner scan = new Scanner(System.in);

        boolean check = true;
        String numero, numeroAgencia, nomeAgencia, nome, cpf;
        double saldo = 0, juros = 0;

        ArrayList<Conta> contas = new ArrayList<Conta>();

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

                    Banco banco = new Banco(numeroAgencia, nomeAgencia);
                    Cliente c = new Cliente(nome, cpf);

                    contas.add(new Conta(numero, banco, c, saldo));

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

                    Banco banco = new Banco(numeroAgencia, nomeAgencia);
                    Cliente c = new Cliente(nome, cpf);

                    contas.add(new Poupanca(numero, banco, c, saldo, juros));

                    System.out.println("Conta cadastrada com sucesso!");

                }

            } else if (op == 2) {

                if (contas.size() > 0) {

                    System.out.println("Digite o cpf : ");
                    cpf = scan.next();

                    for (int i = 0; i < contas.size(); i++) {

                        if (contas.get(i) != null && (contas.get(i) instanceof Poupanca)) {// it's working

                            if (contas.get(i).getC().getCpf().equals(cpf)) {

                                System.out.println("Digite o valor a ser depositado : ");
                                double valor = scan.nextDouble();

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                                System.out.println("Depósito realizado!");
                                System.out.println(
                                        "Saldo da poupança atualizado : " + ((Poupanca) contas.get(i)).getSaldo());

                            }

                        } else {

                            if (contas.get(i).getC().getCpf().equals(cpf)) {

                                System.out.println("Digite o valor a ser depositado : ");
                                double valor = scan.nextDouble();

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                                System.out.println("Depósito realizado!");
                                System.out.println("Saldo atualizado : " + contas.get(i).getSaldo());

                            }
                        }
                    }

                } else {

                    System.out.println("Não há contas cadastradas!");
                }

            } else if (op == 3) {

                if (contas.size() > 0) {

                    System.out.println("Digite o cpf : ");
                    cpf = scan.next();

                    for (int i = 0; i < contas.size(); i++) {

                        if (contas.get(i) != null && (contas.get(i) instanceof Poupanca)) {

                            if (contas.get(i).getC().getCpf().equals(cpf)) {

                                System.out.println("Digite o valor a ser depositado : ");
                                double valor = scan.nextDouble();

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                System.out.println("Dia de rendimento!");
                                System.out.println("Saldo da poupança atualizado : "
                                        + ((Poupanca) contas.get(i)).renderJuros(valor));

                            }

                        }
                    }
                }

            } else if (op == 4) {

                if (contas.size() > 0) {

                    System.out.println("Digite o n° da agencia : ");
                    numeroAgencia = scan.next();
                    System.out.println("Digite o nome da agencia : ");
                    nomeAgencia = scan.next();

                    for (Conta conta : contas) {

                        if (conta.getBanco().getNumeroAgencia().equals(numeroAgencia)
                                & conta.getBanco().getNomeAgencia().equals(nomeAgencia)) {

                            System.out.println("Nome : " + conta.getC().getNome() + "\nCpf : " + conta.getC().getCpf());
                        }

                    }

                } else {

                    System.out.println("Conta não cadastrada!");
                }

            } else if (op == 6) {

                System.out.println("Listar contas");
                System.out.println("*************");

                for (int i = 0; i < contas.size(); i++) {

                    System.out.println(contas.get(i).toString());
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
