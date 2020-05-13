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

        int op = 0;
        scan.nextLine();

        while (check) {

            System.out.println("Digite a opção desejada");
            System.out.println("|||Criar ingressos|||");
            System.out.println("1- Ingresso Normal");
            System.out.println("2- Ingresso VIP(digite 1 - camarote superior. 2 - camarote inferior");
            System.out.println("... ... ... ...");
            op = scan.nextInt();

            if (op == 1) {

                valor = 100;

                ingressos.add(new Normal(valor));

                System.out.println("Compra efetuada! valor: " + valor + "tipo do ingresso : (normal)");

            } else if (op == 2) {
                int tipoCamarote;
                System.out.println("Digite o tipo do ingresso : ");
                tipoCamarote = scan.nextInt();

                if (tipoCamarote == 1) {

                    valor = 100;
                    valorAdSup = 200;

                    ingressos.add(new CamaroteSup(valor,valorAdSup));

                    System.out.println("Compra efetuada! valor: " + valor + "tipo do ingresso : (camarote superior)");


                }
            }
        }
    }
}