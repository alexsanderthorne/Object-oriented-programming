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
            System.out.println("0. Sair");

            int op = 0;
            System.out.println("Digite a opção desejada : ");

            op = scan.nextInt();
            scan.nextLine();

            if (op == 1) {

                boolean continua = true;

                while (continua) {

                    if (contas.size() <= 9) {

                        int tipoConta = 0;
                        System.out.println(
                                "Digite '1' para Conta normal; '2' para Conta poupança; '0' para voltar ao Menu; ");
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

                            System.out.println("Conta cadastrada com sucesso!\n");

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
                            juros = 0.1;

                            Banco banco = new Banco(numeroAgencia, nomeAgencia);
                            Cliente c = new Cliente(nome, cpf);

                            contas.add(new Poupanca(numero, banco, c, saldo, juros));

                            System.out.println("Conta cadastrada com sucesso!\n");

                        } else if (tipoConta == 0) {

                            System.out.println("... ... ...");
                            continua = false;

                        }

                    } else {

                        continua = false;
                        System.out.println("Limite de contas excedido.");

                    }
                }

            } else if (op == 2) {

                if (contas.size() > 0) {

                    System.out.println("Digite o cpf : ");
                    cpf = scan.next();

                    for (int i = 0; i < contas.size(); i++) {

                        if (contas.get(i) != null && (contas.get(i) instanceof Poupanca)) {

                            if (contas.get(i).getC().getCpf().equals(cpf)) {

                                System.out.println("Digite o valor a ser depositado : ");
                                double valor = scan.nextDouble();

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                                System.out.println("Depósito realizado!");
                                System.out.println("Saldo da poupança atualizado : "
                                        + ((Poupanca) contas.get(i)).getSaldo() + "\n");

                            }

                        } else {

                            if (contas.get(i).getC().getCpf().equals(cpf)) {

                                System.out.println("Digite o valor a ser depositado : ");
                                double valor = scan.nextDouble();

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                                System.out.println("Depósito realizado!");
                                System.out.println("Saldo atualizado : " + contas.get(i).getSaldo() + "\n");

                            }
                        }
                    }

                } else {

                    System.out.println("Não há contas cadastradas!\n");
                }

            } else if (op == 3) {

                if (contas.size() > 0) {

                    System.out.println("Digite o cpf : ");
                    cpf = scan.next();

                    for (int i = 0; i < contas.size(); i++) {

                        if (contas.get(i) != null && (contas.get(i) instanceof Poupanca)) {

                            if (contas.get(i).getC().getCpf().equals(cpf)) {

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                System.out.println("Dia de rendimento!");
                                System.out.println("Saldo da poupança atualizado : "
                                        + ((Poupanca) contas.get(i)).renderJuros() + "\n");

                                System.out.println("Saldo : " + contas.get(i).getSaldo());
                                System.out.println("Dia de rendimento!");
                                System.out.println("Saldo da poupança atualizado : "
                                        + ((Poupanca) contas.get(i)).renderJuros() + "\n");

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

                            System.out.println(
                                    "Nome : " + conta.getC().getNome() + "\nCpf : " + conta.getC().getCpf() + "\n");
                        }

                    }

                } else {

                    System.out.println("Não há conta cadastrada!\n");
                }
            }

            else if (op == 5) {

                if (contas.size() > 0) {

                    System.out.println("Digite o nome do cliente : ");
                    nome = scan.next();

                    for (int i = 0; i < contas.size(); i++) {

                        if (contas.get(i) != null && (contas.get(i) instanceof Poupanca)) {

                            if (contas.get(i).getC().getNome().equals(nome)) {

                                System.out.println("Digite o novo numero da agencia : ");
                                numeroAgencia = scan.next();
                                System.out.println("Digite o novo nome da agencia : ");
                                nomeAgencia = scan.next();
                                contas.get(i).getBanco().setNumeroAgencia(numeroAgencia);
                                contas.get(i).getBanco().setNomeAgencia(nomeAgencia);
                                System.out.println("n° agencia : " + contas.get(i).getBanco().getNumeroAgencia());
                                System.out.println("nome da agencia : "
                                        + ((Poupanca) contas.get(i)).getBanco().getNomeAgencia() + "\n");
                            }

                        } else {

                            if (contas.get(i).getC().getNome().equals(nome)) {

                                System.out.println("Digite o novo numero da agencia : ");
                                numeroAgencia = scan.next();
                                System.out.println("Digite o novo nome da agencia : ");
                                nomeAgencia = scan.next();
                                contas.get(i).getBanco().setNumeroAgencia(numeroAgencia);
                                contas.get(i).getBanco().setNomeAgencia(nomeAgencia);
                                System.out.println("n° agencia : " + contas.get(i).getBanco().getNumeroAgencia());
                                System.out.println(
                                        "nome da agencia : " + contas.get(i).getBanco().getNomeAgencia() + "\n");

                            }
                        }
                    }

                } else {

                    System.out.println("Não há conta cadastrada!\n");

                }

            } else if (op == 0) {

                check = false;
                break;

            } else {

                System.out.println("Opção inválida!/n");

            }
        }

        scan.close();
    }

}