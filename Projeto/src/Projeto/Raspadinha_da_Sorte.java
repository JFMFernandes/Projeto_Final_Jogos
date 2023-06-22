/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;
/*
*@autor Beatriz Moleirinho
*/
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Raspadinha_da_Sorte {
    
    static double aposta = 10;
    static Scanner in = new Scanner(System.in);
    private static ArrayList < String > figSorte = new ArrayList < > ();

    public static void figurasSorte() {

        String fig1, fig2, fig3, fig4, fig5;
        fig1 = figSorteada();
        fig2 = figSorteada();
        fig3 = figSorteada();
        fig4 = figSorteada();
        fig5 = figSorteada();
        figSorte.add(fig1);
        figSorte.add(fig2);
        figSorte.add(fig3);
        figSorte.add(fig4);
        figSorte.add(fig5);
    
    }

    public static String figSorteada() {

        String[] fSorte = {
            "Estrela",
            "Pote",
            "Trevo",
            "Núvem",
            "Sol",
            "Casa",
            "Moeda",
            "Cofre",
            "Unicórnio"
        };
        int rand = ThreadLocalRandom.current().nextInt(fSorte.length);
        String figura = fSorte[rand];

        return figura;
    }
    //	----------------------------------------------------------------------------

    public static double mainRaspadinha(double creditos_p) {

        String figuraRasp;

        int op, j = 0;
        double creditos_rs = creditos_p;
        double somaAposta = 0;
        System.out.println("Olá " + Projeto_Jogos.nome + "!");
        System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
        System.out.println("»»Bem-vindo/a à Raspadinha da Sorte««");
        System.out.println("«««««««««««««««««««««««««««««««««««««");

        do {

            if (creditos_rs > 0) {
                figuraRasp = figSorteada();
                System.out.println("Introduza 1 - Raspar");
                System.out.println(" Qualquer outro numero para sair");
                while (! in .hasNextInt()) {
                    System.out.println("Erro: Insira um valor correto!");
                    System.out.print("»» Opção:         "); in .next();
                }
                op = in .nextInt();


                if (op == 1) {
                    System.out.println("»»Figura da Sorte: " + figuraRasp + " ««");
                    figurasSorte();
                    for (String a: figSorte) {
                        System.out.println("Figura do Jogo: " + a);
                    }
                    int n = 0;
                    for (int i = 0; i < figSorte.size(); i++) {
                        if (figSorte.get(i).contains(figuraRasp)) { //get(i).contains(figuraRasp)){
                            j++;
                        }
                    }
                    figSorte.clear();
                    if (j == 0) {
                        creditos_rs -= aposta;
                        System.out.println(Projeto_Jogos.nome + ", não teve figuras iguais. Perdeu " + aposta + ", tem agora " + creditos_rs + " créditos");
                    }
                    if (j == 1) {
                        System.out.println(Projeto_Jogos.nome + ", teve uma figura igual. Desta vez não perde nem ganha nada, tem agora " + creditos_rs + " créditos");

                    }
                    if (j == 2) {
                        somaAposta = aposta * 2;
                        creditos_rs += somaAposta;
                        System.out.println(Projeto_Jogos.nome + ", teve duas figuras iguais. Ganhou " + somaAposta + ", tem agora " + creditos_rs + " créditos");
                    }
                    if (j == 3) {
                        somaAposta = aposta * 3;
                        creditos_rs += somaAposta;
                        System.out.println(Projeto_Jogos.nome + ", teve três figuras iguais. Ganhou " + somaAposta + ", tem agora " + creditos_rs + " créditos");
                    }
                    if (j == 4) {
                        somaAposta = aposta * 5;
                        creditos_rs += somaAposta;
                        System.out.println(Projeto_Jogos.nome + ", teve quatro figuras iguais. Ganhou " + somaAposta + ", tem agora " + creditos_rs + " créditos");
                    }
                    if (j == 5) {
                        somaAposta = aposta * 10;
                        creditos_rs += somaAposta;
                        System.out.println(Projeto_Jogos.nome + ", teve cinco figuras iguais. Ganhou " + somaAposta + ", tem agora " + creditos_rs + " créditos");
                    }
                    j = 0;
                } else {
                    System.out.println("Saindo...");
                    break;
                }
            } else {

                System.out.println("Saindo... Créditos insuficientes!");
                op = 2;
            }

        } while (op == 1);

        return creditos_rs;
    }
}  

