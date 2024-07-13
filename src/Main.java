import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        boolean displayMenu = true;

        while (displayMenu){
            System.out.println("""
                    =========================
                    CONVERSOR DE MOEDAS
                    
                    Opções de conversão
                    [1] Dólar => Peso Argerntino
                    [2] Peso Argentino => Dólar
                    [3] Dólar => Real Brasileiro
                    [4] Real Brasileiro => Dólar
                    [5] Dólar => Euro
                    [6] Euro => Dólar
                    [0] Sair da aplicação
                    =========================
                    """);
            System.out.println("Digite o número:");
            int opcao = leitura.nextInt();

            switch (opcao){
                case 0:
                    displayMenu = false;
                    break;
                case 1:
                    instanciaObjetoParDeMoeda("USD", "ARS", valorParaSerConvertido());
                    break;
                case 2:
                    instanciaObjetoParDeMoeda("ARS", "USD", valorParaSerConvertido());
                    break;
                case 3:
                    instanciaObjetoParDeMoeda("USD", "BRL", valorParaSerConvertido());
                    break;
                case 4:
                    instanciaObjetoParDeMoeda("BRL", "USD", valorParaSerConvertido());
                    break;
                case 5:
                    instanciaObjetoParDeMoeda("USD", "EUR", valorParaSerConvertido());
                    break;
                case 6:
                    instanciaObjetoParDeMoeda("EUR", "USD", valorParaSerConvertido());
                    break;
                default:
                    System.out.println("\nOpção inválida");
                    displayMenu = false;
                    break;

            }

        }

    }

    public static void instanciaObjetoParDeMoeda(String moedaBase, String moedaAlvo, double valor){
        Conversor conversor = new Conversor();
        ParDeMoeda parDeMoeda = conversor.converteMoeda(moedaBase, moedaAlvo, valor);
        System.out.println(conversor.formatarResultado(parDeMoeda, valor));
    }

    public static Double valorParaSerConvertido(){
        Scanner leitura = new Scanner(System.in);
        System.out.println("\n Digite o valor para ser convertido:");
        return leitura.nextDouble();
    }


}
