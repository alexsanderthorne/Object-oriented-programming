package Heranca.imposto_de_renda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String nome, cnpj, cpf;
        double rendaBruta;
        // ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        boolean check = true;
        int op = 0;

        while (check) {

            System.out.println("*** *** ***");
            System.out.println("Calcular imposto de renda");
            System.out.println("*** *** ***");
            System.out.println("1- Cadastrar Pessoa Física");
            System.out.println("2- Cadastrar Pessoa juridica");
            System.out.println("3- Calcular imposto de renda(procurar pelo cpf/cnpj)");
            System.out.println("0- Sair");
            System.out.println("*** *** ***");
            System.out.println("Digite a opção desejada : ");

            if (op == 3) {
                int tipo_pessoa = 0;
                if (tipo_pessoa == 1) {
                    System.out.println("Digite o nome");
                    nome = scan.nextLine();
                    System.out.println("Digite o cpf('ex:666.666.666-66')");
                    cpf = scan.nextLine();
                    System.out.println("Digite a renda bruta");
                    rendaBruta = scan.nextDouble();
                    // Pessoa p = new PessoaFisica(nome, rendaBruta, cpf);
                    Pessoa p = new PessoaFisica(nome, rendaBruta, cpf);

                    System.out.println("Pessoa física adicionada com sucesso!");
                    System.out.println("*** *** ***");
                    System.out.println(nome + " Pagará de impostoR$ " + p.calcularImposto());

                }
            }
        }

    }

}
