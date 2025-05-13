import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static int FuncaoHash(String palavra, int tam){
        int hash = 0;
        // ex: Abobora : pega letra A -> int da tabela assci 
        // A = valor 65
        hash = 13+palavra.toUpperCase().charAt(0);
        return hash % tam;
    }
    public static boolean buscarPalavra(String palavra, ArrayList<String> [] tabelaHash, int tam){
        if (tabelaHash[FuncaoHash(palavra, tam)].contains(palavra)) {
            return true;
        } else {
            return false;
        }

    }   

    public static void main(String[] args) throws Exception {
        int totalCategorias = 26;
        int tabelaHash[] = new int[totalCategorias];
        ArrayList<String> TabelaHash[] = new ArrayList[totalCategorias];
        // iniciar a tabela 
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println( i + " ->" + TabelaHash[i]);
            TabelaHash[i] = new ArrayList<String>();

        }
        System.out.println("------------- INTANCIADAS ----------");
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println( i + " ->" + TabelaHash[i]);
        }
        System.out.println("------------- GERANDO PALAVRAS ----------");
        for (int i = 0; i < 100; i++) {
            String palavra = GeradorPalavras.gerarPalavraAleatoria(3, 10);
            int categoria = FuncaoHash(palavra, totalCategorias);
            TabelaHash[categoria].add(palavra);
        }            
            System.out.println("------------- PREENCHIDAS ----------");
            for (int i = 0; i < tabelaHash.length; i++) {
                System.out.println( i + " ->" + TabelaHash[i]);
            }


        Scanner scanner = new Scanner(System.in);
        System.out.println("------------- BUSCA DE PALAVRA ----------");
        System.out.print("Digite uma palavra a ser buscada: ");
        String palavraBusca = scanner.nextLine();

        if (buscarPalavra(palavraBusca, TabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraBusca + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavraBusca + "' não encontrada.");
        }

        scanner.close();
    }
}
