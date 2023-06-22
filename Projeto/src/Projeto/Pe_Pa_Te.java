/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;
import java.util.*;
/**
 *
 * @author Beatriz Moleirinho
 */
public class Pe_Pa_Te {
    static double aposta = 10;
    static Scanner in = new Scanner(System.in);

    static double jogar(double creditos) {
        double creditosjogo = creditos;
        int escu, escp, vit = 0, der = 0, emp = 0;
        Random r = new Random();


        do {
            if (creditosjogo > 0) {
                System.out.println("Selecione 1-Pedra, 2-Papel, 3-Tesoura, 4-Sair");
                System.out.print("Opção: ");
                while (! in .hasNextInt()) {
                    System.out.println("Erro: Insira um valor correto!");
                    System.out.print("»» Opção:         "); in .next();
                }
                escu = in .nextInt();
                switch (escu) {
                    case 1:
                        for (escp = 0; escp < 2; escp++) {
                            escp = r.nextInt(3) + 1;
                        }
                        if (escp == 1) {
                            System.out.println(Projeto_Jogos.nome + ", você EMPATOU!! Escolheu 1-Pedra e o PC também!");
                            System.out.println("Tem " + creditosjogo);
                            emp++;
                        } else if (escp == 2) {
                            System.out.println(Projeto_Jogos.nome + ", você PERDEU!! Escolheu 1-Pedra e o PC escolheu 2-Papel!");
                            der++;
                            creditosjogo -= aposta;
                            System.out.println("Tem " + creditosjogo);
                        } else {
                            System.out.println(Projeto_Jogos.nome + ", você GANHOU!! Escolheu 1-Pedra e o PC escolheu 3-Tesoura!");
                            vit++;
                            creditosjogo += aposta;
                            System.out.println("Tem " + creditosjogo);
                        }
                        break;
                    case 2:
                        for (escp = 0; escp < 2; escp++) {
                            escp = r.nextInt(3) + 1;
                        }
                        if (escp == 2) {
                            System.out.println(Projeto_Jogos.nome + ", você EMPATOU!! Escolheu 2-Papel e o PC também!");
                            System.out.println("Tem " + creditosjogo);
                            emp++;
                        } else if (escp == 3) {
                            System.out.println(Projeto_Jogos.nome + ", você PERDEU!! Escolheu 2-Papel e o PC escolheu 3-Tesoura!");
                            der++;
                            creditosjogo -= aposta;
                            System.out.println("Tem " + creditosjogo);
                        } else {
                            System.out.println(Projeto_Jogos.nome + ", você GANHOU!! Escolheu 2-Papel e o PC escolheu 1-Pedra!");
                            vit++;
                            creditosjogo += aposta;
                            System.out.println("Tem " + creditosjogo);
                        }
                        break;
                    case 3:
                        for (escp = 0; escp < 2; escp++) {
                            escp = r.nextInt(3) + 1;
                        }
                        if (escp == 3) {
                            System.out.println(Projeto_Jogos.nome + ", você EMPATOU!! Escolheu 3-Tesoura e o PC também!");
                            System.out.println("Tem " + creditosjogo);
                            emp++;
                        } else if (escp == 1) {
                            System.out.println(Projeto_Jogos.nome + ", você PERDEU!! Escolheu 3-Tesoura e o PC escolheu 1-Pedra!");
                            der++;
                            creditosjogo -= aposta;
                            System.out.println("Tem " + creditosjogo);
                        } else {
                            System.out.println(Projeto_Jogos.nome + ", você GANHOU!! Escolheu 3-Tesoura e o PC escolheu 2-Papel!");
                            vit++;
                            creditosjogo += aposta;
                            System.out.println("Tem " + creditosjogo);
                        }
                        break;
                    case 4:
                        System.out.println(Projeto_Jogos.nome + ", Obrigada por ter jogado, terminou com " + vit + " vitórias, " + emp + " empates e " + der + " derrotas");
                        System.out.println("Total créditos de jogo: " + creditosjogo);
                        break;
                    default:
                        System.out.println("Seleccionou uma opção inválida!");
                }
            } else {
                System.out.println(Projeto_Jogos.nome + ", Obrigada por ter jogado, terminou com " + vit + " vitórias, " + emp + " empates e " + der + " derrotas");
                System.out.println("Total créditos de jogo: " + creditosjogo);
                break;
            }

        } while (escu != 4);

        return creditosjogo;
    }

    public static double mainPPT(double creditos) {
        double creditos_ppt = creditos;
        int op;
        System.out.println("Olá " + Projeto_Jogos.nome + "!");
        System.out.println("»»»»»» Jogo do Pedra, Papel, Tesoura ««««««");
        System.out.println("Escolha uma opção");
        System.out.println("1-Jogar");
        System.out.println("2-Sair");
        System.out.print("Opção: ");
        while (! in .hasNextInt()) {
            System.out.println("Erro: Insira um valor correto!");
            System.out.print("Opção: "); in .next();
        }
        op = in .nextInt();
        if (op == 1) {
            creditos_ppt = jogar(creditos);
        } else {
            System.out.println("Até à proxima! " + Projeto_Jogos.nome + ", ficou com " + creditos_ppt + " créditos");
        }

        return creditos_ppt;
    }
}