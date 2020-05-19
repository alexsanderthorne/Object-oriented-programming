import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean check = true;
        double valor;
        double valorAd;
        double valorAdSup;
        double[][] localizacao;
        List<Ingresso> ingressos = new ArrayList<Ingresso>();

        while (check) {

            System.out.println("|||Criar ingressos|||");
            System.out.println("1- Ingresso Normal");
            System.out.println("2- Ingresso VIP(digite 1 - camarote superior. 2 - camarote inferior");
            System.out.println("... ... ... ...");

            System.out.println("Digite a opção desejada");
            int op = 0;

            op = scan.nextInt();
            scan.nextLine();

            if (op == 1) {

                valor = 100;

                ingressos.add(new Normal(valor));

                Normal n = new Normal();
                Ingresso i = new Ingresso();
                // System.out.print(n.imprimeValor());

                System.out.println("Compra efetuada! tipo do ingresso : (normal)");
                System.out.println(n.toString());

            } else if (op == 2) {
                int tipoCamarote;
                System.out.println("Digite o tipo do ingresso : ");
                tipoCamarote = scan.nextInt();

                if (tipoCamarote == 1) {

                    valor = 100;
                    valorAdSup = 200;

                    ingressos.add(new CamaroteSup(valor, valorAdSup));

                    Ingresso i = new Ingresso();
                    // Object i = (CamaroteSup) ingressos;
                    System.out.println(i.getClass());

                    System.out.println("Compra efetuada! tipo do ingresso : (camarote superior)");
                    System.out.println(i.toString());
                }
            } else if (op == 3) {

            }
        }
    }
}