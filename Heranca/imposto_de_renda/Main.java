package Heranca.imposto_de_renda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String nome, cnpj, cpf;
        double rendaBruta = 0;
        // ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        boolean check = true;
        int op = 0;

        while (check) {

            System.out.println("*** *** =) ***");
            System.out.println("Calcular imposto de renda");
            System.out.println("*** *** ***");
            System.out.println("1- Cadastrar Pessoa Física");
            System.out.println("2- Cadastrar Pessoa juridica");
            System.out.println("3- Calcular imposto de renda(procurar pelo cpf/cnpj)");
            System.out.println("0- Sair");
            System.out.println("*** *** ***");

            System.out.println("Digite a opção desejada : ");
            op = scan.nextInt();
            scan.nextLine();

            if (op == 3) {
                int tipo_pessoa = 0;
                System.out.println("Digite 1-Pessoa física. 2-Pessoa jurídica");
                tipo_pessoa = scan.nextInt();
                if (tipo_pessoa == 1) {

                    PessoaFisica p1 = new PessoaFisica();
                    p1.setNome("joe cara de porco");
                    p1.setRendaBruta(1000);
                    p1.setCpf("0923r4fsdvged");

                    System.out.println("Pessoa física adicionada com sucesso!");
                    System.out.println("*** *** ***");
                    System.out.println(p1.getNome() + " Pagará de impostoR$ " + p1.calcularImposto());

                } else {

                    System.out.println("Digite o nome");
                    nome = scan.nextLine();
                    System.out.println("digite a renda");
                    rendaBruta = scan.nextDouble();
                    System.out.println("Digite a porra do cnpj");
                    cnpj = scan.nextLine();

                    PessoaJuridica p1 = new PessoaJuridica(nome, rendaBruta, cnpj);

                    System.out.println("Pessoa física adicionada com sucesso!");
                    System.out.println("*** *** ***");
                    System.out.println(p1.getNome() + " Pagará de impostoR$ " + p1.calcularImposto());

                }
            } else if (op == 0) {
                check = false;

            } else {
                System.out.println("Opção inválida");
            }
        }

        scan.close();

    }

}
