import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static <novaLocalizacao> void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean check = true;
        double valor;
        double valorAd;
        double valorAdSup;
        double[][] localizacao;

        while (check) {

            System.out.println("|||Criar ingressos|||");
            System.out.println("1- Ingresso Normal");
            System.out.println("2- Ingresso VIP(digite 1 - camarote superior. 2 - camarote inferior");
            System.out.println("... ... ... ...");
            System.out.println("0- Sair");

            System.out.println("Digite a opção desejada");
            int op = 0;

            op = scan.nextInt();
            scan.nextLine();

            if (op == 1) {

                Ingresso n = new Normal();
                n.setValor(100);

                System.out.println("Compra efetuada! tipo do ingresso : (normal) Valor : " + n.imprimeValor());

            } else if (op == 2) {
                int tipoCamarote;
                System.out.println("Digite o tipo do ingresso : ");
                tipoCamarote = scan.nextInt();

                if (tipoCamarote == 1) {

                    valor = 300;
                    valorAdSup = 200;

                    // Ingresso i = (CamaroteSup) ingressos;
                    // System.out.println(i.getClass());
                    // List <Ingresso> up = new ArrayList<Ingresso>();
                    // up.add(up.set(valor, valorAdSup));
                    Ingresso up = new CamaroteSup(valor, valorAdSup);
                    up.setValor(100);

                    System.out.println(
                            "Compra efetuada! tipo do ingresso : (camarote superior) Valor : " + up.imprimeValor());

                } else if (tipoCamarote == 2) {

                    valorAd = 66;
                    System.out.println("Digite a posição da cadeira do cliente(linha)");
                    int linha = scan.nextInt();
                    System.out.println("Digite a posição da cadeira do cliente(coluna)");
                    int coluna = scan.nextInt();

                    localizacao = new double[linha][coluna];
                    // Ingresso i = (CamaroteSup) ingressos;
                    // System.out.println(i.getClass());
                    Ingresso inf = new CamaroteInf(valorAd, localizacao);
                    inf.setValor(100);

                    System.out.println(
                            "Compra efetuada! tipo do ingresso : (camarote inferior) Valor : " + inf.imprimeValor());
                    // System.out.println("Localização do espectador : " + inf.a);

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